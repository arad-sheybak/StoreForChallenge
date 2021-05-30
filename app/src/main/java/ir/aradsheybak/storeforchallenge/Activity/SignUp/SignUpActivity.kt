package ir.aradsheybak.storeforchallenge.Activity.SignUp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ir.aradsheybak.storeforchallenge.Components.BaseActivity
import ir.aradsheybak.storeforchallenge.Dialog.NoInternet.NoInternetActivity
import ir.aradsheybak.storeforchallenge.databinding.ActivitySignUpBinding

class SignUpActivity : BaseActivity() {
    private val emailPattern: String = "[a-zA-Z0-9.-_]+@[a-z]+\\.+[a-z]+"
    private lateinit var email: String
    private lateinit var password: String
    private lateinit var confirmPassword : String
    private lateinit var context: Context


    private lateinit var binding : ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        defineBinding()
        context = this
        binding.btnSignUp.setOnClickListener {
            if(checkNetwork()){
                //connection is ok
                doSignUp()
            }else{
                //network is not connect
                changeActivity(NoInternetActivity::class.java)

            }

        }

    }
    private fun getEmail(){
        email = binding.etInputEmailSignUp.text.toString()

    }

    private fun getPassword() {
        password = binding.etInputPasswordSignUp.text.toString()
    }

    private fun getConfirmPassword(){
        confirmPassword = binding.etInputConfirmPassword.text.toString()
    }

    private fun defineBinding(){
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun validateEmail(eml: String): Boolean {
        return eml.matches(emailPattern.toRegex())
    }

    private fun checkEmail(): Boolean {
        if (email.length == 0) {
            //error ---> username is empty
            showToastLong("username is empty")
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
    private fun doSignUp(){
        getEmail()
        if (checkEmail()){
            getPassword()
            if (checkPassword()){
                getConfirmPassword()
                if (checkConfirmPassword()){
                    //true --> do sign up
                    showToastLong("Sign up OK")
                }else{
                    showToastLong("password and confirm password doesnt match")
                }
            }
        }
    }
}