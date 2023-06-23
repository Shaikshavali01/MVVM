package com.example.firstprojectusingmvvm.data.api

import com.example.firstprojectusingmvvm.data.model.DriverResponse
import com.example.firstprojectusingmvvm.data.model.MRData
import okhttp3.ResponseBody

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET


interface ApiService {

    @GET("1/results.json")
      fun getTotalResult() : Call<DriverResponse>
                            //:  Call<MRData> Response<MRData>


    @GET("1/results.json")
    fun getTotalResult1() : Call<ResponseBody>


}