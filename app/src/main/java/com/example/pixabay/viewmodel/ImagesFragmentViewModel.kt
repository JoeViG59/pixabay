package com.example.pixabay.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pixabay.model.Hits
import com.example.pixabay.model.Images
import com.example.pixabay.repository.Network
import com.example.pixabay.repository.PixabayAPI
import com.example.pixabay.repository.PixabayImplentation
import com.google.gson.Gson
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

class ImagesFragmentViewModel : ViewModel() {

    val network : Network= Network()
    val gson : Gson = network.providesGson()
    val loggingInterceptor : HttpLoggingInterceptor = network.loggingInterceptor()
    val okHttpClient : OkHttpClient = network.okHttpClient(loggingInterceptor)
    val retrofitAPI: PixabayAPI = network.retrofitAPI(okHttpClient,gson)

    private val _imagesData : MutableLiveData<Images> = MutableLiveData()
    val images : LiveData<Images> get() = _imagesData

    fun callApi(){
        retrofitAPI.getImages().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({imagesResponse ->
                Log.d("API_PIXABAY","Total is: ${imagesResponse.total} and ${imagesResponse.hits}")
                _imagesData.postValue(imagesResponse)
            },{
                Log.d("API_PIXABAY","Total is: ${it.message}")
            })
    }






}