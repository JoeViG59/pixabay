package com.example.pixabay.repository

import com.example.pixabay.model.Images
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Single

interface PixabayAPI {
    @GET()
    fun getImages(@Query("key") apiKey : String = KEY) : Single<Images>
    companion object {
        val BASE_API = "https://pixabay.com/api/"
        val KEY = "36316169-64ed8c76750890dcb9ca26a48"
    }
}