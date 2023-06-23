package com.example.firstprojectusingmvvm.data.api

import android.content.Context
import android.util.Log

import com.example.firstprojectusingmvvm.Utils.Constants
import com.example.firstprojectusingmvvm.data.model.MRData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiCallUsingRetrofit(private val context: Context) {

    public fun getServiceRetro(url : String):ApiService {
        lateinit var service : ApiService
        if(Constants.isNetworkAvailable(context)){
            val retrofit  = Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()


            service = retrofit.create(ApiService::class.java)
            return service

        }
        return service

    }

}