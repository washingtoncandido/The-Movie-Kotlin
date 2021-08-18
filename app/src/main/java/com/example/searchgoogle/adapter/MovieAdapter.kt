package com.example.searchgoogle.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.searchgoogle.MovieViewHolder
import com.example.searchgoogle.R
import com.example.searchgoogle.data.model.Result

class MovieAdapter(private val movies: List<Result>
) : RecyclerView.Adapter<MovieViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
       holder.bindMovie(movies.get(position))
    }

    override fun getItemCount(): Int {
       return movies.size
    }

}