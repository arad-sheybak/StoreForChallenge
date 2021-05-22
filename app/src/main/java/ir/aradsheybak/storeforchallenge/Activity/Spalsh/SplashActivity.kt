package ir.aradsheybak.storeforchallenge.Activity.Spalsh

import android.content.Context
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import ir.aradsheybak.storeforchallenge.Components.Base
import ir.aradsheybak.storeforchallenge.R
import ir.aradsheybak.storeforchallenge.databinding.ActivitySplashBinding


class SplashActivity : AppCompatActivity() {
    private lateinit var view: ActivitySplashBinding
    private lateinit var anim: Animation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding()
        defineAnimation()
        setLogo()
        setAnimation()
    }

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase?.let { ViewPumpContextWrapper.wrap(it) })
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