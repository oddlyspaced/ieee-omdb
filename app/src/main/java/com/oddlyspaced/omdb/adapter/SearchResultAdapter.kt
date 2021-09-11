package com.oddlyspaced.omdb.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.oddlyspaced.omdb.databinding.ItemMovieResultBinding
import com.oddlyspaced.omdb.modal.SearchResult

class SearchResultAdapter(private val results: ArrayList<SearchResult>) : RecyclerView.Adapter<SearchResultAdapter.SearchResultViewHolder>() {

    inner class SearchResultViewHolder(private val binding: ItemMovieResultBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: SearchResult) {
            Glide.with(binding.root).load(data.posterLink).into(binding.imgResult)
            binding.txResult.text = data.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchResultViewHolder {
        return SearchResultViewHolder(ItemMovieResultBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: SearchResultViewHolder, position: Int) {
        holder.bind(results[position])
    }

    override fun getItemCount(): Int {
        return results.size
    }
}