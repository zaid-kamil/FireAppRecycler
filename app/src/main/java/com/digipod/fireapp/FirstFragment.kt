package com.digipod.fireapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.digipod.fireapp.data.DataSource
import com.digipod.fireapp.databinding.FragmentFirstBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    // create a field for firebase firestore
    private val db = Firebase.firestore

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.movieRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        DataSource().setup(requireContext(), db, binding.movieRecyclerView, "movies")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}