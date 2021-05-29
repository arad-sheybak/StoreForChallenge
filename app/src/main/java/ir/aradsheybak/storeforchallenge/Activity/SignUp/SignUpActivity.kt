package ir.aradsheybak.storeforchallenge.Activity.SignUp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ir.aradsheybak.storeforchallenge.Components.BaseActivity
import ir.aradsheybak.storeforchallenge.databinding.ActivitySignUpBinding

class SignUpActivity : BaseActivity() {
    private lateinit var binding : ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        defineBinding()

    }
    private fun defineBinding(){
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}