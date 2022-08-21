package com.digipod.fireapp.data

import android.util.Log
import com.digipod.fireapp.model.Movie
import com.google.firebase.firestore.FirebaseFirestore

class DataSource {

    fun loadData(db: FirebaseFirestore, colName: String) {
        val movieList : ArrayList<Movie>
        db.collection(colName).get()
            .addOnSuccessListener {
                Log.d("DataSource", "Successfully loaded data")
            }
            .addOnFailureListener {
                Log.d("DataSource", "Error getting documents: " + it.message)
            }
    }

}