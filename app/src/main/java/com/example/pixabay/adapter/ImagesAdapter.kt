package com.example.pixabay.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pixabay.databinding.ImagesItemBinding
import com.example.pixabay.model.Hits
import com.example.pixabay.model.Images

class ImagesAdapter(
    private var imagesList : MutableList<Hits> = mutableListOf()
) : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ImagesItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return imagesList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(imagesList[position])
    }

    fun update(images: List<Hits>){
        imagesList.addAll(images)
        notifyDataSetChanged()
    }

}

class ViewHolder(
    private val binding: ImagesItemBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(imagesItem: Hits){

        binding.textTags.text = imagesItem.tags
    }
}