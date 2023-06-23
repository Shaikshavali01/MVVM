package com.example.firstprojectusingmvvm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.firstprojectusingmvvm.data.repositories.Repository

class MainViewModelFactory(private val repository: Repository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        return super.create(modelClass)

        return DriverViewModel(repository) as T
    }


}