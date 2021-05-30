package ir.aradsheybak.storeforchallenge.Activity.Spalsh

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.bumptech.glide.Glide
import ir.aradsheybak.storeforchallenge.Activity.Login.LoginActivity
import ir.aradsheybak.storeforchallenge.Components.BaseActivity
import ir.aradsheybak.storeforchallenge.Dialog.NoInternet.NoInternetActivity
import ir.aradsheybak.storeforchallenge.R
import ir.aradsheybak.storeforchallenge.databinding.ActivitySplashBinding


class SplashActivity : BaseActivity() {
    private lateinit var view: ActivitySplashBinding
    private lateinit var anim: Animation
    private lateinit var context: Context
    private val TIME_OUT: Long = 3000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context = this
        viewBinding()
        defineAnimation()
        setLogo()
        setAnimation()
        showSplash()
    }

    fun showSplash() {
        Handler().postDelayed({
            if (checkNetwork()) {
                //go to Login
                changeActivity(context, LoginActivity::class.java)
                finish()

            } else {
                //show no internet dialog

                changeActivity(context, NoInternetActivity::class.java)

            }
        }, TIME_OUT)
    }


    private fun viewBinding() {
        view = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(view.root)
    }

    private fun setLogo() {
        Glide.with(this).load(R.drawable.ic_logo).into(view.ivLogoSplash)

    }

    private fun defineAnimation() {
        anim = AnimationUtils.loadAnimation(applicationContext, R.anim.fade_in)
    }

    private fun setAnimation() {
        view.ivLogoSplash.startAnimation(anim)
        view.tvSloganSplash.startAnimation(anim)
        view.tvWebSiteSplash.startAnimation(anim)
    }

//list animation ---> https://www.tutorialspoint.com/android/android_animations.htm

}