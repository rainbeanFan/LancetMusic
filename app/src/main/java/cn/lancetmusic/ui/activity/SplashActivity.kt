package cn.lancetmusic.ui.activity

import android.content.Intent
import android.os.Bundle
import cn.lancetmusic.R
import java.util.*

/**
 * Created by Lancet at 2022/5/1 15:31
 */
class SplashActivity: BaseActivity() {

    private var timer: Timer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        init()
    }

    private fun init() {
        timer = Timer()
        timer?.schedule(object:TimerTask(){
            override fun run() {
                goToLoginActivity()
//                goToMainActivity()
            }

        },3000)
    }

    private fun goToMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    private fun goToLoginActivity() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        timer?.cancel()
    }

}