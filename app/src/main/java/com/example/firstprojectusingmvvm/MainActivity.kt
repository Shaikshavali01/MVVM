package com.example.firstprojectusingmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.firstprojectusingmvvm.data.api.ApiCallUsingRetrofit
import com.example.firstprojectusingmvvm.data.api.ApiService
import com.example.firstprojectusingmvvm.data.model.DriverResponse
import com.example.firstprojectusingmvvm.data.repositories.Repository
import com.example.firstprojectusingmvvm.viewmodel.DriverViewModel
import com.example.firstprojectusingmvvm.viewmodel.MainViewModelFactory
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    private lateinit var driverViewModel : DriverViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val apiCallUsingRetrofit = ApiCallUsingRetrofit(this)

        val service : ApiService = apiCallUsingRetrofit.getServiceRetro("https://ergast.com/api/f1/2006/")
        val repo = Repository(service)
        driverViewModel = ViewModelProvider(this,MainViewModelFactory(repo))[DriverViewModel ::class.java]

        lifecycleScope.launch {

            driverViewModel.getDriverResult().enqueue(object: Callback<DriverResponse> {
                override fun onResponse(call: Call<DriverResponse>, response: Response<DriverResponse>) {
                    Log.d("QQ_SUCCESS","${response.body()}")

                }

                override fun onFailure(call: Call<DriverResponse>, t: Throwable) {
                    Log.d("QQ_FAILURE","${t.localizedMessage}")

                }
            })
        }
        driverViewModel.result.observe(this, Observer {
            Log.e("Model data...", it.MRData.RaceTable.Races.get(0).Results.get(4).Driver.nationality)
        })

    }


}