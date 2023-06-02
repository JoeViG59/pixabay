package com.example.pixabay

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pixabay.adapter.ImagesAdapter
import com.example.pixabay.databinding.FragmentImagesBinding
import com.example.pixabay.model.Hits
import com.example.pixabay.model.Images
import com.example.pixabay.viewmodel.ImagesFragmentViewModel

class ImagesFragment : Fragment() {


    private val binding by lazy {
        FragmentImagesBinding.inflate(layoutInflater)
    }

    private val viewModel : ImagesFragmentViewModel by viewModels()

    private val imagesAdapter by lazy {
        ImagesAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

       viewModel.callApi()

        binding.rvImages.apply {
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            adapter = imagesAdapter
        }

//        imagesAdapter.update()
//        viewModel.images.value.let {
//            it?.let { it1 -> imagesAdapter.update(it1.hits) }
//        }

      viewModel.images.observe(viewLifecycleOwner){
          Log.d("ImagesFragmImagesFragmentent",it.total.toString())
          Log.d("ImagesFragmImagesFragmentent",it.totalHits.toString())
          Log.d("ImagesFragmImagesFragmentent",it.hits.size.toString())
          Log.d("ImagesFragmImagesFragmentent",it.hits[0].tags)
          imagesAdapter.update(it.hits)
      }

        return binding.root
    }

}