package com.example.navigationapplication

import junit.framework.Assert.assertEquals
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.withContext
import org.junit.Test
import java.util.concurrent.atomic.AtomicBoolean

/**
 * author: Angelo.Luo
 * date : 01/24/2024 3:59 PM
 * description:协程测试
 * 在测试中建议使用：runTest来进行测试
 */
class CoroutinesTest {

    suspend fun fetchData(): String {
        delay(1000L)
        return "Hello world"
    }

    @Test
    fun dataShouldBeHelloWorld() = runTest {
        val data = fetchData()
        println(data)
    }


    @Test
    fun standardTest() = runTest(StandardTestDispatcher()) {//默认使用的就是StandardTestDispatcher：侧重于并发的情形
        val user = UserPerson()
        launch { user.register("angelo") }
        launch { user.register("making") }

        println("data is ${user.getAllUsers()}")//后面的数据为空，因为；上面的测试线程没有执行结束，不会执行上面的两个协程
    }

    @Test
    fun standardTest01() = runTest(StandardTestDispatcher()) {
        val user = UserPerson()
        launch { user.register("angelo") }//协程1
        launch { user.register("making") }//协程2

        advanceUntilIdle()//可使用 advanceUntilIdle 先让两个待处理的协程执行其工作

        println("data is ${user.getAllUsers()}")
    }

    @Test
    fun yieldingTest() = runTest(UnconfinedTestDispatcher()) {
        val userRepo = UserPerson()

        launch {
            userRepo.register("Alice")
            delay(10L)//因为这里进行了挂起，其他协程继续执行，所有没有Bob的信息
            userRepo.register("Bob")
        }
        CoroutineScope(Dispatchers.IO)
        var atomicBoolean = AtomicBoolean(true)

        println("yieldingTest data is ${userRepo.getAllUsers()}") // ❌ Fails 没有Bob的信息
    }

    @Test
    fun repoInitWorksAndDataIsHelloWorld() = runTest {
        val dispatcher = StandardTestDispatcher(testScheduler)
        val repository = Repository(dispatcher)

        repository.initialize()
        advanceUntilIdle() // Runs the new coroutine
        println("initialized data is ${repository.initialized.get()}")

        val data = repository.fetchData() // No thread switch, delay is skipped
        println("lasted data is $data")
    }

}

class Repository(private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO) {
    private val scope = CoroutineScope(ioDispatcher)
    val initialized = AtomicBoolean(true)

    fun initialize() {
        scope.launch {
            initialized.set(false)
        }
    }

    suspend fun fetchData(): String = withContext(ioDispatcher) {
        require(initialized.get()) { "Repository should be initialized first" }
        delay(500L)
        "Hello world"
    }

}

class UserPerson() {

    private val nameList: MutableList<String> = mutableListOf()

    fun register(name: String) {
        nameList.add(name)
    }

    fun getAllUsers(): String {
        var allUsersName = ""
        nameList.forEach {
            allUsersName += "$it - "
        }
        allUsersName = allUsersName.replace("- ", "")
        return allUsersName
    }
}