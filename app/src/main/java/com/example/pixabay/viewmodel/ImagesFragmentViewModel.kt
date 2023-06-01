package com.example.pixabay.viewmodel

import androidx.lifecycle.ViewModel
import com.example.pixabay.model.Hits
import com.example.pixabay.model.Images

class ImagesFragmentViewModel : ViewModel() {

    var callApi : String? = null

    var hits1: Hits = Hits(
        10,"Tag1","URL1"
    )

    var hits2 : Hits = Hits(
        10,"Tag2","URL1"
    )

    var hitsList : List<Hits> = listOf<Hits>(hits1,hits2)

    val sampleImagesClass : Images = Images(10,20, hitsList)

    val listImages : MutableList<Images> = mutableListOf()

    fun callApi(){
        if (callApi == null){
            callApi = "Calling API"
            println(callApi)
        }
    }
}