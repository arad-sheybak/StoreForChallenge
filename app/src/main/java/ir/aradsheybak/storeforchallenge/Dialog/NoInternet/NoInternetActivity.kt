package ir.aradsheybak.storeforchallenge.Dialog.NoInternet

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ir.aradsheybak.storeforchallenge.databinding.ActivityNoInternetBinding

class NoInternetActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNoInternetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoInternetBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
    }
}