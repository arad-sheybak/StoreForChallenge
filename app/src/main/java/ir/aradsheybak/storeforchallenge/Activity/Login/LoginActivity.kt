package ir.aradsheybak.storeforchallenge.Activity.Login

import android.content.Context
import android.os.Bundle
import ir.aradsheybak.storeforchallenge.Activity.ForgetPassword.STP1.ForgetPasswordGetEmailActivity
import ir.aradsheybak.storeforchallenge.Activity.Main.MainActivity
import ir.aradsheybak.storeforchallenge.Activity.SignUp.SignUpActivity
import ir.aradsheybak.storeforchallenge.Components.BaseActivity
import ir.aradsheybak.storeforchallenge.Components.SPClass
import ir.aradsheybak.storeforchallenge.Dialog.NoInternet.NoInternetActivity
import ir.aradsheybak.storeforchallenge.databinding.ActivityLoginBinding

class LoginActivity : BaseActivity() {
    private lateinit var context: Context
    private lateinit var binding: ActivityLoginBinding

    private lateinit var email: String
    private lateinit var password: String
    private lateinit var sp: SPClass

    //arad-._SHEYBAK@gmail.com
    private val emailPattern: String = "[a-zA-Z0-9.-_]+@[a-z]+\\.+[a-z]+"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context = this
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sp = SPClass(context)

        binding.btnLogin.setOnClickListener {
            if (checkNetwork()) {
                sendRequest()
            } else {
                //show no internet dialog
                changeActivity(NoInternetActivity::class.java)
            }
        }

        binding.tvTitleSignUp.setOnClickListener {
            changeActivity(SignUpActivity::class.java)
//            val intent = Intent(applicationContext, SignUpActivity::class.java)
//            startActivity(intent)

        }
        binding.tvTitleForgetPassword.setOnClickListener {
            changeActivity(ForgetPasswordGetEmailActivity::class.java)
        }
    }

    private fun sendRequest() {

        getEmail()
        if (checkEmail()) {
            //true --> now you can check password
            getPassword()
            if (checkPassword()) {
                //true ---> now you can send request to server
//                showToastLong("now you can send request to server")
                sp.saveBoolean(sp.USER_LOGIN,true)
                changeActivity(MainActivity::class.java)
            }
        }

    }

    private fun getEmail() {
        email = binding.etUsernameLogin.text.toString()
    }

    private fun getPassword() {
        password = binding.etPasswordLogin.text.toString()
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

    private fun validateEmail(eml: String): Boolean {
        return eml.matches(emailPattern.toRegex())
    }
}


