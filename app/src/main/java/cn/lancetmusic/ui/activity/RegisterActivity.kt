package cn.lancetmusic.ui.activity

import android.os.Bundle
import cn.lancetmusic.R


class RegisterActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        initView()

    }

    private fun initView() {
        initNarBar(showBack = true,title = "注册")
    }


}


