package com.example.firstprojectusingmvvm.data.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.firstprojectusingmvvm.data.api.ApiService
import com.example.firstprojectusingmvvm.data.model.Driver
import com.example.firstprojectusingmvvm.data.model.DriverResponse
import com.example.firstprojectusingmvvm.data.model.MRData
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Repository(private val apiService: ApiService){

    private val resLiveData = MutableLiveData<DriverResponse>()

    val res : LiveData<DriverResponse>
        get() = resLiveData



    suspend fun getDriverResult(): Call<DriverResponse> {
        val result = apiService.getTotalResult()
        return apiService.getTotalResult()

      /*  if(result.isSuccessful){
            return result.body()?.MRData?.RaceTable?.Results?.get(4)?.Driver!!
        }*/
    }


}


