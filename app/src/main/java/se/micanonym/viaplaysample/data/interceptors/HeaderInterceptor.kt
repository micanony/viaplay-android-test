package se.micanonym.viaplaysample.data.interceptors

import okhttp3.Interceptor
import okhttp3.Response

private const val CONTENT_TYPE_HEADER_FIELD_NAME = "Content-Type"
private const val CONTENT_TYPE_HEADER_FIELD_VALUE = "application/json"

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
        builder.header(CONTENT_TYPE_HEADER_FIELD_NAME, CONTENT_TYPE_HEADER_FIELD_VALUE)
        return chain.proceed(builder.build())
    }
}
