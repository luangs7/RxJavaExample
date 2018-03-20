package br.com.squarebits.lausgirl.data.retrofit

import android.content.Context

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit
import com.google.gson.Gson
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory


/**
 * Created by Luan on 17/10/17.
 */
class ApiManager {

    var endpoint = "https://api.myjson.com/bins/"

    lateinit var context : Context
    var retrofit: Retrofit
    var okHttpClient: OkHttpClient





    constructor(context: Context){


        this.context = context

        val logInterceptor = HttpLoggingInterceptor()
        logInterceptor.level = HttpLoggingInterceptor.Level.BODY


        okHttpClient = OkHttpClient().newBuilder()
                .connectTimeout((30000 * 6).toLong(), TimeUnit.MILLISECONDS)
                .readTimeout((30000 * 6).toLong(), TimeUnit.MILLISECONDS)
                .writeTimeout((30000 * 6).toLong(), TimeUnit.MILLISECONDS)
                .addInterceptor(logInterceptor)
                .build()


        val gson = GsonBuilder()
                .create()


        retrofit = Retrofit.Builder()
                .baseUrl(endpoint)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

    }

    constructor(context: Context, newEndpoint: String){
        this.context = context

        val logInterceptor = HttpLoggingInterceptor()
        logInterceptor.level = HttpLoggingInterceptor.Level.BODY


        okHttpClient = OkHttpClient().newBuilder()
                .connectTimeout((30000 * 6).toLong(), TimeUnit.MILLISECONDS)
                .readTimeout((30000 * 6).toLong(), TimeUnit.MILLISECONDS)
                .writeTimeout((30000 * 6).toLong(), TimeUnit.MILLISECONDS)
                .addInterceptor(logInterceptor)
                .build()




        val gson = GsonBuilder()
                .create()


        retrofit = Retrofit.Builder()
                .baseUrl(newEndpoint)
                .client(okHttpClient)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

    }


    constructor(retrofit: Retrofit, okHttpClient: OkHttpClient){
        this.retrofit = retrofit
        this.okHttpClient = okHttpClient
    }



    constructor(context: Context,retrofit: Retrofit, okHttpClient: OkHttpClient){
        this.context = context
        this.retrofit = retrofit
        this.okHttpClient = okHttpClient
    }


}