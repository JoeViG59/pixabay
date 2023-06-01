package com.example.pixabay.repository

import com.example.pixabay.model.Images
import rx.Single

class PixabayImplentation(
    val pixabayAPI: PixabayAPI
) : PixabayIterface {
    override fun getAllImages(): Single<Images> {
        return pixabayAPI.getImages("key")
    }
}