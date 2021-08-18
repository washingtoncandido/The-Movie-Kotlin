package com.example.searchgoogle

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.searchgoogle.data.model.Result
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_list.view.*

class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var imageViewFilmes: ImageView? = null
    private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
    fun bindMovie(movie: Result) {

        itemView.text_film.text = movie.originalTitle
        itemView.data_film.text = movie.releaseDate
        itemView.legend_film.text = movie.legendOriginal

        imageViewFilmes = itemView.findViewById(R.id.imag_post_film)
        Picasso.get()
            .load(IMAGE_BASE + movie.posterPath)
            .into(imageViewFilmes)
    }


}