package com.example.navigationapplication.http

import android.os.Environment
import android.util.Log
import android.widget.Toast
import okhttp3.Call
import okhttp3.Callback
import okhttp3.FormBody
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.Response
import java.io.File
import java.io.IOException
import java.util.concurrent.TimeUnit
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONObject

/**
 * author: Angelo.Luo
 * date : 01/10/2024 11:16 AM
 * description:
 */

// todo 在下面的response中就是读取了body，那么后面就不能再读取了，否则会报错；这是okhttp中规定的
//加了object表示单例
object HiOkHttp {

    private val client02: OkHttpClient

    init {
        //使用自带的拦截器
        var httpLoggingInterceptor = HttpLoggingInterceptor()
        //选择对应的日志打印
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        client02 = OkHttpClient.Builder()//构造者设计模式
            .connectTimeout(10, TimeUnit.SECONDS)//连接的超时时间
            .readTimeout(10, TimeUnit.SECONDS)//读取超时时间
            .writeTimeout(10, TimeUnit.SECONDS)//写超时时间
            .addInterceptor(httpLoggingInterceptor)//自带拦截器的使用
            .build();
    }

    //初始化，创建链接客户端
    private var client = OkHttpClient.Builder()//构造者设计模式
        .connectTimeout(10, TimeUnit.SECONDS)//连接的超时时间
        .readTimeout(10, TimeUnit.SECONDS)//读取超时时间
        .writeTimeout(10, TimeUnit.SECONDS)//写超时时间
        .addInterceptor(LoggingInterceptor())//自定义拦截器的使用
        .build();

    /**
     * get请求-同步
     */

    fun getSync(url: String): Unit {
        //如果在MainActivity主线程中不用Thread调用同步请求，会抛出异常：NetworkOnMainThreadException
        //所以在主线程中只能通过Thread一个子线程使用同步请求
        //构建一个请求
        val request: Request = Request.Builder().url(url).build()
        Log.e("getSync", request.toString())
        //创建一个请求对象
        val newCall: Call = client.newCall(request)
        Thread {
            //进行同步请求（只有请求返回了结果 才会执行下面的代码）
            val response: Response = newCall.execute()
            val body = response.body?.string()
            println("get request`s body is :${body}")
        }.start()
    }

    /**
     * get请求-异步
     */
    fun getAsync(url: String): Unit {
        val request: Request = Request.Builder().url(url).build();
        var call = client.newCall(request)
        call.enqueue(object : Callback {
            //调用失败返回信息
            override fun onFailure(call: Call, e: IOException) {
                Log.e("getAsync", "异步调用异常，错误信息是：${e.message}")
            }

            //调用成功返回的响应
            override fun onResponse(call: Call, response: Response) {
                Log.e("getAsync：成功", "异步调用成功的数据：${response.body.toString()}")
            }
        })
    }

    /**
     * post请求-同步
     */
    fun postSync(url: String) {
        //创建一个请求体body
        val body = FormBody.Builder()
            .add("username", "admin")
            .add("password", "admin123")
            .add("captcha", "iD42")
            .add("checkKey", "1629428467008")
            .build()
        //创建一个request对象
        val request = Request.Builder().url(url).post(body).build()
        //获取一个call对象
        val call = client.newCall(request)
        //调用同步方法execute，也是需要创建一个thread的
        Thread {
            var response = call.execute()
            Log.e("请求的url：", request.url.toString())
            println(response.body?.toString())
        }
    }

    /**
     * post请求-异步
     */

    fun postAsync(url: String) {
        val body = FormBody.Builder().add("username", "admin").build();
        val request = Request.Builder().url(url).post(body).build();
        var call = client.newCall(request)
        call.enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e("异步调用失败：", e.message.toString())
            }

            override fun onResponse(call: Call, response: Response) {
                Log.e("异步调用成功：", response.body.toString())
            }
        })
    }

    /**
     * post请求-异步表单文件上传
     */
    fun postFormFileUpdate(url: String) {
        //获取本地文件
        val file = File(Environment.getExternalStorageDirectory(), "file.png")
        if (!file.exists()) {
            //这里null需要传：context
            Toast.makeText(null, "文件不存在", Toast.LENGTH_SHORT).show()
            return
        }
        //创建body
        var formDataPart: RequestBody =
            MultipartBody.Builder().addFormDataPart("username", "angelo")
                .addFormDataPart(
                    "file.png",
                    "file",
                    file.asRequestBody("application/octet-stream".toMediaType())
                ).build()
        var request = Request.Builder().url(url).post(formDataPart).build()
        var call = client.newCall(request)
        call.enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e("异步表单文件提交错误：", e.message.toString())
            }

            override fun onResponse(call: Call, response: Response) {
                Log.e("异步表单提交成功：", response.body.toString())
            }
        })
    }

    /**
     * post请求-异步json字符串类型提交
     * post请求-异步字符串提交:objectJson.toString().toRequestBody("text/plain;charset=utf-8".toMediaType())
     */
    fun postStringJson(url: String) {
        val objectJson = JSONObject()
        objectJson.put("userName", "angelo")
        objectJson.put("password", "999000")
//        RequestBody.create(MediaType.parse("application/json;charset=utf-8"),objectJson.toString()) 写法一：已废弃，不可用
//        RequestBody.create("application/json;charset=utf-8".toMediaType(),objectJson.toString())  写法二：已废弃
        //写法三
        var requestBody: RequestBody =
            objectJson.toString().toRequestBody("application/json;charset=utf-8".toMediaType())
        var request = Request.Builder().url(url).post(requestBody).build()
        var call = client.newCall(request)
        call.enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e("异步表单文件提交错误：", e.message.toString())
            }

            override fun onResponse(call: Call, response: Response) {
                Log.e("异步表单提交成功：", response.body.toString())
            }
        })
    }
}
