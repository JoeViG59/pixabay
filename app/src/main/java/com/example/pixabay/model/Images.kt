package com.example.pixabay.model

data class Images(
    val total : Int,
    val totalHits : Int,
    val hits: List<Hits>
)
