package com.example.pixabay.repository

import com.example.pixabay.model.Images
import io.reactivex.Single


class PixabayImplentation(
    val pixabayAPI: PixabayAPI
) : PixabayIterface {
    override fun getAllImages(): Single<Images> {
        return pixabayAPI.getImages("key")
    }
}