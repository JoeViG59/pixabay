package com.example.pixabay

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pixabay.adapter.ImagesAdapter
import com.example.pixabay.databinding.FragmentImagesBinding
import com.example.pixabay.model.Hits
import com.example.pixabay.model.Images

class ImagesFragment : Fragment() {

    var hits1:Hits = Hits(
        10,"Tag1","URL1"
    )

    var hits2 : Hits = Hits(
        10,"Tag2","URL1"
    )

    var hitsList : List<Hits> = listOf<Hits>(hits1,hits2)



    val sampleImagesClass : Images = Images(10,20, hitsList)

    val listImages : MutableList<Images> = mutableListOf()

    private val binding by lazy {
        FragmentImagesBinding.inflate(layoutInflater)
    }

    private val imagesAdapter by lazy {
        ImagesAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.rvImages.apply {
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            adapter = imagesAdapter
        }

//        listImages.add(sampleImagesClass)

        imagesAdapter.update(hitsList)
        return binding.root
    }

}