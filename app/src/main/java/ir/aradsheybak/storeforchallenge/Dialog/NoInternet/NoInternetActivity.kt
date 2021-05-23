package ir.aradsheybak.storeforchallenge.Dialog.NoInternet

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Build
import android.os.Bundle
import android.view.ViewGroup
import ir.aradsheybak.storeforchallenge.Components.BaseActivity
import ir.aradsheybak.storeforchallenge.databinding.ActivityNoInternetBinding

class NoInternetActivity : BaseActivity() {

    private lateinit var binding: ActivityNoInternetBinding
    private lateinit var context: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context = this
        binding = ActivityNoInternetBinding.inflate(layoutInflater)
        setContentView(binding.root)
        defineDialog()
        binding.btnMobileData.setOnClickListener { goToMobileData() }
        binding.btnWifi.setOnClickListener { goToWifi() }


    }

    fun defineDialog() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }

        val mWidth: ViewGroup.LayoutParams = binding.clRootNoInternet.layoutParams
        mWidth.width = getWidthScreen(context) - 100
        binding.clRootNoInternet.layoutParams = mWidth

    }

    fun goToWifi(){
        val intent = Intent(Intent.ACTION_MAIN, null)
        intent.addCategory(Intent.CATEGORY_LAUNCHER)
        val cn = ComponentName("com.android.settings", "com.android.settings.wifi.WifiSettings")
        intent.component = cn
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }

    fun goToMobileData(){
        val intent = Intent()
        intent.component = ComponentName(
            "com.android.settings",
            "com.android.settings.Settings\$DataUsageSummaryActivity"
        )
        startActivity(intent)
    }
}