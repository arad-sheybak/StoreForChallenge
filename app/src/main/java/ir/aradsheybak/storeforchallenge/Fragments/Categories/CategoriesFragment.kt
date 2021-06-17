package ir.aradsheybak.storeforchallenge.Fragments.Categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ir.aradsheybak.storeforchallenge.databinding.FragmentCategoriesBinding
import ir.aradsheybak.storeforchallenge.databinding.FragmentHomeBinding

class CategoriesFragment:Fragment() {
    private lateinit var binding: FragmentCategoriesBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoriesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}