package com.qamaiofficial.qamai

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.core.content.ContextCompat

class ForgotPassword : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        initialize()
    }

    private fun initialize(){

        //here the app is initialized with navigation bar and status bar colors

        if(Build.VERSION.SDK_INT>=28)
        {
            //Notches display support

            val attrib = window.attributes
            attrib.layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_DEFAULT
        }

        //In lollipop the status bar color can not be set so we have a condition for it

        if(!(Build.VERSION.SDK_INT==21 || Build.VERSION.SDK_INT==22))
        {
            window.statusBarColor= ContextCompat.getColor(this,R.color.QamaiThemeColor)
        }

        val color= ContextCompat.getColor(this,R.color.QamaiThemeColor)

        getWindow().setNavigationBarColor(color)

    }
}

