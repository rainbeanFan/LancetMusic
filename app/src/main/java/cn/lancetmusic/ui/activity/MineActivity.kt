package cn.lancetmusic.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import cn.lancetmusic.R
import cn.lancetmusic.util.UserUtils
import kotlin.properties.Delegates


class MineActivity : BaseActivity() {

    private var modifyPassword by Delegates.notNull<TextView>()

    private var logout by Delegates.notNull<Button>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mine)

        initView()

    }

    private fun initView() {
        initNarBar(showBack = true,title = "个人中心")

        modifyPassword = findView(R.id.tv_modify_password)

        logout = findView(R.id.btn_logout)

        modifyPassword.setOnClickListener{
            startActivity(Intent(this, ModifyPasswordActivity::class.java))
        }

        logout.setOnClickListener {
            UserUtils.logout(this)
        }

    }


}