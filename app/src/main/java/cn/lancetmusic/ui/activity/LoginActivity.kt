package cn.lancetmusic.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import cn.lancetmusic.R
import cn.lancetmusic.ui.widget.InputView
import cn.lancetmusic.util.UserUtils
import com.blankj.utilcode.util.ToastUtils
import kotlin.properties.Delegates

/**
 * Created by Lancet at 2022/5/1 15:43
 */
class LoginActivity : BaseActivity() {

    private var inputPhone by Delegates.notNull<InputView>()
    private var inputPassword by Delegates.notNull<InputView>()

    private var register by Delegates.notNull<TextView>()
    private var commitLogin by Delegates.notNull<Button>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initView()
    }

    private fun initView() {
        initNarBar(title = "登录")

        inputPhone = findView(R.id.input_phone)
        inputPassword = findView(R.id.input_password)

        commitLogin = findView(R.id.btn_login)

        register = findView(R.id.tv_register)

        register.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        commitLogin.setOnClickListener {
            if (UserUtils.isValidLogin(
                    this@LoginActivity as Context,
                    inputPhone.getInputStr(),
                    inputPassword.getInputStr()
                )
            ) {
                startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                finish()
            }else{
                startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                finish()
//                ToastUtils.showLong("账号或密码错误")
            }
        }


    }

}