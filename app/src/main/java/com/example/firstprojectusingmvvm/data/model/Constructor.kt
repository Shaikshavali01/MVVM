package com.example.firstprojectusingmvvm.data.model

import java.io.Serializable

data class Constructor(
    val constructorId : String,
    val url : String,
    val nationality : String
) : Serializable
