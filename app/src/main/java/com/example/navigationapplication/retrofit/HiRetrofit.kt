package com.example.navigationapplication.retrofit

import android.util.Log
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import okhttp3.RequestBody.Companion.asRequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PartMap
import retrofit2.http.Query
import retrofit2.http.QueryMap
import java.io.File
import java.util.concurrent.TimeUnit

/**
 * author: Angelo.Luo
 * date : 01/11/2024 9:42 AM
 * description:
 */
object HiRetrofit {

    //构建OkHttp客户端对象
    val client: OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(10, TimeUnit.SECONDS)
        .readTimeout(10, TimeUnit.SECONDS)
        .writeTimeout(10, TimeUnit.SECONDS)
        .build()

    //构建一个retrofit对象
    val retrofit: Retrofit = Retrofit.Builder().client(client)//添加客户端对象，因为底层就是OkHttp
        .baseUrl("http://localhost:8080/server/")//请求地址的前缀
        .addConverterFactory(GsonConverterFactory.create())//设置Json转换的格式
        .build();


}

interface ApiService {

    /**
     * 通过用户ID获取用户数据
     */
    @GET("user/queryUserById")
    fun queryUserById(@Query("UserId") user: String): Call<String>;

    @Headers("User-Agent:android", "apikey:123456")
    @GET("user/query")
    fun queryAll(): Call<String>

    /**
     * 参数较多的情况下可以使用@QueryMap，只能用在GET请求上
     */
    @GET("user/queryUserByCondition")
    fun queryUserByCondition(@QueryMap params: Map<String, String>): Call<String>

    /**
     * 很多情况下，我们需要上传json格式的数据。当我们注册新用户的时候，因为用户注册时的数据相对较多
     *        并可能以后会变化，这时候，服务端可能要求我们上传json格式的数据。此时就要@Body注解来实现。
     *        直接传入实体,它会自行转化成Json, @Body只能用在POST请求上
     *        字符串提交
     *        这里会将account对象转换成json字符串
     */
    @POST("use/update")
    fun update(@Body account: Account): Call<String>

    /**
     * 表单提交(键值对的提交)
     */
    @POST("user/executePost")
    @FormUrlEncoded
    fun executePost(@FieldMap maps: Map<String, Object>): Call<String>

    /**
     * 表单上传文件（键值对提交，文件上传）
     * 加上@Multipart才可以上传文件
     */
    @Multipart
    @POST("upload/upload")
    fun upload(
        @FieldMap params: Map<String, String>,
        @PartMap maps: Map<String, MultipartBody.Part>
    ): Call<String>


}

class UseClass() {
    fun invokeUpload() {
        var apiService: ApiService = HiRetrofit.retrofit.create(ApiService::class.java)
        //设置参数
        val params = mapOf(Pair("userName", "angelo"), Pair("password", "123"))
        //设置请求的文件信息
        val file01: File = File("C:\\Notes\\1.项目笔记.docx")
        val file02: File = File("C:\\Notes\\1.项目笔记.docx")
        val requestBody01 = file01.asRequestBody("multipart/form-data".toMediaType())
        val requestBody02 = file02.asRequestBody("multipart/form-data".toMediaType())
        var multipartBody = MultipartBody.Builder()
            .setType(MultipartBody.FORM)
            .addFormDataPart("file01", file01.name, requestBody01)
            .addFormDataPart("file02", file02.name, requestBody02)
            .build()
        var call = apiService.upload(params, mapOf("file" to multipartBody.part(0)))
        //使用异步请求
        call.enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                Log.e("成功了：", response.body().toString())
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                Log.e("你失败了：", t.message.toString())
            }

        })
    }
}

open class Account {
    var nameUser: String = "angelo"
    var password: String = "123456"
    var age: Int = 23
    override fun toString(): String {
        return "Account(nameUser='$nameUser', password='$password', age=$age)"
    }
}