package ir.aradsheybak.storeforchallenge.Activity.ForgetPassword.STP3

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ir.aradsheybak.storeforchallenge.Activity.Login.LoginActivity
import ir.aradsheybak.storeforchallenge.Components.BaseActivity
import ir.aradsheybak.storeforchallenge.Dialog.NoInternet.NoInternetActivity
import ir.aradsheybak.storeforchallenge.R
import ir.aradsheybak.storeforchallenge.databinding.ActivityForgetPasswordCreateNewPasswordBinding

class ForgetPasswordCreateNewPasswordActivity : BaseActivity() {
    private lateinit var binding: ActivityForgetPasswordCreateNewPasswordBinding
    private lateinit var context: Context
    private lateinit var password: String
    private lateinit var confirmPassword : String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context = this
        defineBinding()
        binding.btnConfirmNewPassword.setOnClickListener {
            if (checkNetwork()){
                getPassword()
                if (checkPassword()){
                    getConfirmPassword()
                    if (checkConfirmPassword()){
                        //true --> send mew password to server
                        submitNewPassword()
                    }
                }
            }else{
                changeActivity(NoInternetActivity::class.java)
            }

        }

    }

    private fun defineBinding(){
        binding = ActivityForgetPasswordCreateNewPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun getPassword() {
        password = binding.etInputNewPassword.text.toString()
    }

    private fun getConfirmPassword(){
        confirmPassword = binding.etInputConfirmNewPassword.text.toString()
    }

    private fun checkPassword(): Boolean {
        if (password.length == 0) {
            //error ---> password is empty
            showToastLong("password is empty")
            return false
        } else {
            if (password.length >= 6) {
                //min password ok
                return true
            } else {
                //error --> input correct password
                showToastLong("input correct password")
                return false
            }
        }

    }

    private fun checkConfirmPassword(): Boolean {
        if (confirmPassword.length == 0) {
            //error --> confirm password is empty
            showToastLong("confirm password is empty")
            return false
        } else{
            return confirmPassword.equals(password)
        }

    }

    private fun submitNewPassword(){
        changeActivity(LoginActivity::class.java)
    }

}