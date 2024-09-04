package com.example.navigationapplication.http

import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import okio.Buffer

/**
 * author: Angelo.Luo
 * date : 01/10/2024 4:01 PM
 * description:自定义一个http请求的拦截器，可以用作日志大打印
 */
class LoggingInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        //当前执行的开始时间
        val currentTimeMillis = System.currentTimeMillis();
        val request = chain.request()
        //打印相关信息
        println(
            String.format(
                "sending request %s on %s%n%s",
                request.url,
                chain.connection(),
                request.headers
            )
        )
        //执行请求
        val response: Response = chain.proceed(request);
        //读取requestBody中的数据
        var buffer = Buffer()
        request.body?.writeTo(buffer)
        val requestBodyStr = buffer.readUtf8()
        println("请求体的数据为：$requestBodyStr")

        //获取响应的数据
        var responseBodyStr = response.body?.string()
        println("responseBody is $responseBodyStr")

        //返回一个Response
        //需要新建一个Response，因为在前面已经使用过，就不能再使用了
        val medialType = response.body?.contentType()
        //直接返回一个新的response
        return response.newBuilder().body(responseBodyStr?.toResponseBody(medialType)).build()

    }
}