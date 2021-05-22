package ir.aradsheybak.storeforchallenge.Components

import android.R
import android.app.Activity
import android.app.Application
import android.app.Service
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.util.DisplayMetrics
import android.widget.Toast
import io.github.inflationx.calligraphy3.CalligraphyConfig
import io.github.inflationx.calligraphy3.CalligraphyInterceptor
import io.github.inflationx.viewpump.ViewPump


@Suppress("DEPRECATION")
class Base : Application() {

    override fun onCreate() {
        super.onCreate()
        ViewPump.init(
                ViewPump.builder()
                        .addInterceptor(
                                CalligraphyInterceptor(
                                        CalligraphyConfig.Builder()
                                                .setDefaultFontPath("fonts/lalezar.ttf")
                                                .setFontAttrId(R.attr.font)
                                                .build()
                                )
                        )
                        .build()
        )
    }


}
