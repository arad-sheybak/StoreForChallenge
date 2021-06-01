package ir.aradsheybak.storeforchallenge.Activity.ForgetPassword.STP2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ir.aradsheybak.storeforchallenge.Activity.ForgetPassword.STP3.ForgetPasswordCreateNewPasswordActivity
import ir.aradsheybak.storeforchallenge.Components.BaseActivity
import ir.aradsheybak.storeforchallenge.Dialog.NoInternet.NoInternetActivity
import ir.aradsheybak.storeforchallenge.R
import ir.aradsheybak.storeforchallenge.databinding.ActivityForgetPasswordVerifyEmailBinding

class ForgetPasswordVerifyEmailActivity : BaseActivity() {
    private lateinit var binding: ActivityForgetPasswordVerifyEmailBinding
    private lateinit var context: Context
    private lateinit var password: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context = this
        defineBinding()
        binding.btnVerifyEmail.setOnClickListener {
            if (checkNetwork()){
                getPassword()
                if (checkPassword()){
                    // true --> send verification code for validation
                    sendCodeForValidation()
                }
            }else{
                changeActivity(NoInternetActivity::class.java)
            }

        }

    }
    private fun defineBinding(){
        binding = ActivityForgetPasswordVerifyEmailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun getPassword() {
        password = binding.etVerificationCode.text.toString()
    }

    private fun checkPassword(): Boolean {
        if (password.length == 0) {
            //error ---> password is empty
            showToastLong("verification code is empty")
            return false
        } else {
            if (password.length == 6) {
                //min password ok
                return true
            } else {
                //error --> input correct password
                showToastLong("input correct verification code")
                return false
            }
        }

    }

    private fun sendCodeForValidation(){
        changeActivity(ForgetPasswordCreateNewPasswordActivity::class.java)
    }
}
