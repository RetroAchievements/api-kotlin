package org.retroachivements.api.core

import com.google.gson.GsonBuilder
import com.haroldadmin.cnradapter.NetworkResponseAdapterFactory

import org.retroachivements.api.data.RetroCredentials
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


open class CoreClient(credentials: RetroCredentials, baseUrl: String, debugging: Boolean = false) {
    private val gson = GsonBuilder()
        .registerTypeAdapterFactory(DateFormatAdapterFactory())
        .create()

    // custom [OkHttpClient] client to add an authentication interceptor
    var httpClient: OkHttpClient = OkHttpClient.Builder().apply {
        addInterceptor(AuthenticatorInterceptor(credentials))

        if (debugging) {
            addInterceptor(HttpLoggingInterceptor().apply {
                setLevel(HttpLoggingInterceptor.Level.BODY)
            })
        }
    }.build()

    // custom [Retrofit] client to add custom [OkHttpClient] and add Gson (JSON) support
    val retroClient: Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(NetworkResponseAdapterFactory())
        .baseUrl(baseUrl)
        .client(httpClient)
        .build()
}
