package com.qamaiofficial.qamai

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.animation.AnimationUtils
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_splash.*
import androidx.core.content.PermissionChecker




class SplashActivity : AppCompatActivity() {

    //This is where the splash screen runs for 3 seconds

    private var mDelayHandler: Handler? = null
    private val SPLASH_DELAY: Long = 3000 //3 seconds

    internal val mRunnable: Runnable = Runnable {
        if (!isFinishing) {

            val intent = Intent(applicationContext, HomePage::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        initialize()


        logo_qamai.startAnimation(AnimationUtils.loadAnimation(this, R.anim.pulse))

        //Initialize the Handler
        mDelayHandler = Handler()

        //Navigate with delay
        mDelayHandler!!.postDelayed(mRunnable, SPLASH_DELAY)

    }

    public override fun onDestroy() {

        if (mDelayHandler != null) {
            mDelayHandler!!.removeCallbacks(mRunnable)
        }

        super.onDestroy()
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

        val color=ContextCompat.getColor(this,R.color.QamaiThemeColor)

        getWindow().setNavigationBarColor(color)

    }

}



