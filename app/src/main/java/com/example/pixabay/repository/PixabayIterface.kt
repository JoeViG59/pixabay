package com.example.pixabay.repository

import com.example.pixabay.model.Images
import io.reactivex.Single

interface PixabayIterface {
    fun getAllImages(): Single<Images>
}