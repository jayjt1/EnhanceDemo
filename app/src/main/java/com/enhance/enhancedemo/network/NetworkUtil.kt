package com.enhance.enhancedemo.network

/**
 * Created by riniramac001 on 28/12/16.
 */

import com.enhance.enhancedemo.util.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object NetworkUtil {

    private var retrofit: Retrofit? = null
    val client: Retrofit?
        get() {

            if (retrofit == null) {

                val logging = HttpLoggingInterceptor()
                logging.level = HttpLoggingInterceptor.Level.BODY

                val okHttpClient = TrustUnsafe.unsafeOkHttpClient
                val builder = okHttpClient.newBuilder()
                builder.connectTimeout(15, TimeUnit.SECONDS)
                builder.readTimeout(30, TimeUnit.SECONDS)

                builder.addInterceptor(logging)

                retrofit = Retrofit.Builder()
                        .baseUrl(Constants.BASE_URL)
                        .client(builder.build())
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .build()
            }
            return retrofit
        }
}
