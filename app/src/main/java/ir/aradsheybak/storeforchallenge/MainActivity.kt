package ir.aradsheybak.storeforchallenge

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var fName :String
    private var number : Int = 0
    private var test : Boolean = true
    private var test2: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getFirstName("arad","sheybak")
    }
    private fun getFirstName(fName:String,lName:String){

    }

}