package com.example.uts_apkbookingtiketbioskop
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
class SplashScrennActivity {



    class SplashScreenActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_splash)

            val logo = findViewById<ImageView>(R.id.logo1)
            val animation = AnimationUtils.loadAnimation(this, R.anim.fade_in)
            logo.startAnimation(animation)

            Handler().postDelayed({
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }, 3000) // 3 detik
        }
    }

}