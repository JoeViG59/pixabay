package com.example.pixabay.model

import com.google.gson.annotations.SerializedName

data class Hits(
    @SerializedName("id")
    val id: Int,
    val tags: String,
    val webformatURL: String
)
