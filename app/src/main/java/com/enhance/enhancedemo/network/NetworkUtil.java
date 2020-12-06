package com.enhance.enhancedemo.network;

/**
 * Created by riniramac001 on 28/12/16.
 */

import com.enhance.enhancedemo.util.Constants;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkUtil {

    private static Retrofit retrofit = null;

    public static Retrofit getClient() {

        if (retrofit==null) {

            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);

         //   OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

            OkHttpClient okHttpClient = TrustUnsafe.getUnsafeOkHttpClient();
            OkHttpClient.Builder builder = okHttpClient.newBuilder();
            builder.connectTimeout(15, TimeUnit.SECONDS);
            builder.readTimeout(30, TimeUnit.SECONDS);
           // builder.writeTimeout(15, TimeUnit.SECONDS);

        //    OkHttpClient okHttpClient = TrustUnsafe.getUnsafeOkHttpClient();

            builder.addInterceptor(logging);

            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .client(builder.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
