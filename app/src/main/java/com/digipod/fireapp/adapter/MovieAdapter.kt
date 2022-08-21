package com.digipod.fireapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.digipod.fireapp.R
import com.digipod.fireapp.databinding.ActivityMainBinding.inflate
import com.digipod.fireapp.model.Movie

class MovieAdapter(
    private val context: Context,
    private val movies: List<Movie>
) : RecyclerView.Adapter<MovieAdapter.Holder>() {
    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textMovieName: TextView = itemView.findViewById(R.id.textMovieName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context)
                .inflate(R.layout.single_movie_item_card, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val movie = movies[position]
        holder.textMovieName.text = movie.name
    }

    override fun getItemCount(): Int {
        return movies.size
    }
}