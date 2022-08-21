package com.digipod.fireapp.data

import android.content.Context
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.digipod.fireapp.adapter.MovieAdapter
import com.digipod.fireapp.model.Movie
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject

class DataSource {

    fun setup(
        context: Context,
        db: FirebaseFirestore,
        recycler: RecyclerView,
        colName: String
    ) {
        val movieList = ArrayList<Movie>()
        db.collection(colName).get()
            .addOnSuccessListener { result ->
                Log.d("DataSource", "Successfully loaded data ${result.size()}")
                for (document in result) {
                    val movie = document.toObject<Movie>()
                    movieList.add(movie)
                }
                val adapter = MovieAdapter(context, movieList)
                recycler.adapter = adapter
            }
            .addOnFailureListener {
                Log.d("DataSource", "Error getting documents: " + it.message)
            }

    }

}