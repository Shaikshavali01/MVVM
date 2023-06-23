package com.example.firstprojectusingmvvm.data.model

import java.io.Serializable

data class Driver(
    val driverId : String,
    val url : String,
    val nationality : String
) : Serializable
