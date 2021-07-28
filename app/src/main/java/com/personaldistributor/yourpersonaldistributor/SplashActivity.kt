package com.personaldistributor.yourpersonaldistributor

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
//    var splashSound: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar?.hide()
        val backgroundImg : ImageView = findViewById(R.id.splashLogo)
        val backgroundTxt : TextView = findViewById(R.id.textP)
        val slideAnimation = AnimationUtils.loadAnimation(this,R.anim.slide)
        backgroundImg.startAnimation(slideAnimation)
        val slideAnimationText = AnimationUtils.loadAnimation(this,R.anim.slide_1)
        backgroundTxt.startAnimation(slideAnimationText)
        val backgroundTxt1 : TextView = findViewById(R.id.textD)
        val slideAnimationText1 = AnimationUtils.loadAnimation(this,R.anim.slide_2)
        backgroundTxt1.startAnimation(slideAnimationText1)
//       val splashsound = MediaPlayer.create (this,R.raw.droid1)
//        splashsound.start()



        Handler().postDelayed({
//
//            splashLogo.animate().apply {
//                duration = 2000
//                rotationYBy(360f)
//            }.withEndAction{
//                splashLogo.animate().apply {
//                    duration = 1000
//                    rotationYBy(3600f)
//
//                }.start()
//            }


            val intent = Intent(this@SplashActivity,Login_Activity::class.java)
            startActivity(intent)
            finish()
        },4000)
    }
//    override fun onPause() {
//        super.onPause()
//        splashSound!!.release()
//        finish()
//    }

}
