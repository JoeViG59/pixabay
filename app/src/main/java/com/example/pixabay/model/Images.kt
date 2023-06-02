package com.example.pixabay.model

import com.google.gson.annotations.SerializedName

data class Images(
    @SerializedName("total")
    val total : Int,
    val totalHits : Int,
    val hits: List<Hits>
)
