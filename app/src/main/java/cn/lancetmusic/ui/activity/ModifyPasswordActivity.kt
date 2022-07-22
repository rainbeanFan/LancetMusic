package cn.lancetmusic.ui.activity

import android.os.Bundle
import cn.lancetmusic.R

class ModifyPasswordActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modify_password)

        initView()
    }

    private fun initView() {
        initNarBar(showBack = true,title = "修改密码")



    }
}