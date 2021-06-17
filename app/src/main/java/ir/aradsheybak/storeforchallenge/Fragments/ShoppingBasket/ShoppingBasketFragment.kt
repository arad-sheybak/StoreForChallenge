package ir.aradsheybak.storeforchallenge.Fragments.ShoppingBasket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ir.aradsheybak.storeforchallenge.databinding.FragmentShoppingBasketBinding

class ShoppingBasketFragment: Fragment() {
    private lateinit var binding: FragmentShoppingBasketBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShoppingBasketBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}