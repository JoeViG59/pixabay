package com.example.pixabay.repository

import com.example.pixabay.model.Images
import rx.Single

interface PixabayIterface {
    fun getAllImages(): Single<Images>
}