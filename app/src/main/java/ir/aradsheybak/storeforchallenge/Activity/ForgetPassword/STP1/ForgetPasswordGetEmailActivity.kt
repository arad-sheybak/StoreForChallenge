package ir.aradsheybak.storeforchallenge.Activity.ForgetPassword.STP1

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ir.aradsheybak.storeforchallenge.Activity.ForgetPassword.STP2.ForgetPasswordVerifyEmailActivity
import ir.aradsheybak.storeforchallenge.Components.BaseActivity
import ir.aradsheybak.storeforchallenge.R
import ir.aradsheybak.storeforchallenge.databinding.ActivityForgetPasswordGetEmailBinding

class ForgetPasswordGetEmailActivity : BaseActivity() {
    private lateinit var binding : ActivityForgetPasswordGetEmailBinding
    private lateinit var email : String
    private val emailPattern: String = "[a-zA-Z0-9.-_]+@[a-z]+\\.+[a-z]+"
    private lateinit var context : Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context = this
        defineBinding()
        binding.btnGetVerificationCode.setOnClickListener {
            getEmail()
            if (checkEmail()){
                //true --> send verification code to user email
                sendVerificationCode()
            }
        }

    }

    private fun defineBinding(){
        binding = ActivityForgetPasswordGetEmailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun getEmail(){
        email = binding.etEmailGetEmail.text.toString()
    }

    private fun checkEmail(): Boolean {
        if (email.length == 0) {
            //error ---> username is empty
            showToastLong("email is empty")
            return false
        } else {
            if (validateEmail(email)) {
                //true-->email is valid
                return true
            } else {
                //false --> email is invalid
                showToastLong("email is invalid")
                return false
            }
        }
    }

    private fun validateEmail(eml: String): Boolean {
        return eml.matches(emailPattern.toRegex())
    }

    private fun sendVerificationCode(){
        changeActivity(ForgetPasswordVerifyEmailActivity::class.java)
    }
}