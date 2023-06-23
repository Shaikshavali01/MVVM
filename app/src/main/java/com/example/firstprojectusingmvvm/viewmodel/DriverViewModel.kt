package com.example.firstprojectusingmvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firstprojectusingmvvm.data.model.DriverResponse
import com.example.firstprojectusingmvvm.data.model.MRData
import com.example.firstprojectusingmvvm.data.repositories.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class DriverViewModel(private val repository: Repository): ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getDriverResult()
        }

    }
   suspend fun getDriverResult() = repository.getDriverResult()
    val result :LiveData<DriverResponse>
        get() = repository.res



}