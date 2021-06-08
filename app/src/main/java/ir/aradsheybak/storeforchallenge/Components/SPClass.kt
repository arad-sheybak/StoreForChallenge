package ir.aradsheybak.storeforchallenge.Components

import android.content.Context
import android.content.SharedPreferences

class SPClass(context:Context) {

    private val PREF_NAME = "pref_name"
    val USER_LOGIN = "user_login"
    val shared : SharedPreferences = context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE)

    //function for save integers
    fun saveInt(KEY_NAME:String,value:Int){
        val editor : SharedPreferences.Editor = shared.edit()
        editor.putInt(KEY_NAME,value)
        editor.commit()
    }
    //function for save strings
    fun saveString(KEY_NAME: String,value:String){
        val editor : SharedPreferences.Editor = shared.edit()
        editor.putString(KEY_NAME,value)
        editor.commit()
    }

    //function for save booleans
    fun saveBoolean(KEY_NAME: String,value:Boolean){
        val editor : SharedPreferences.Editor = shared.edit()
        editor.putBoolean(KEY_NAME,value)
        editor.commit()
    }

    //function for get integers
    fun getInt(KEY_NAME: String):Int?{
        return shared.getInt(KEY_NAME,0)
    }

    //function for get strings
    fun getString(KEY_NAME: String):String?{
        return shared.getString(KEY_NAME,"")
    }

    //function for get booleans
    fun getBoolean(KEY_NAME: String):Boolean?{
        return shared.getBoolean(KEY_NAME,false)
    }

}