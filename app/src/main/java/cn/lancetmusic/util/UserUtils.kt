package cn.lancetmusic.util

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.text.TextUtils
import cn.lancetmusic.R
import cn.lancetmusic.ui.activity.LoginActivity
import com.blankj.utilcode.util.RegexUtils
import com.blankj.utilcode.util.ToastUtils

/**
 * Created by Lancet at 2022/5/1 23:42
 */

class UserUtils {

    companion object {


        fun isValidLogin(context: Context, phone: String, password: String): Boolean {

            val isMobileExact = RegexUtils.isMobileExact(phone)
            if (!isMobileExact) {
                ToastUtils.showShort("手机号码格式不正确")
                return false
            }
            if (TextUtils.isEmpty(password)) {
                ToastUtils.showShort("密码不能为空")
                return false
            }

            return true
        }

        fun logout(context: Context){
            val intent = Intent(context, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            context.startActivity(intent)
//            startActivity 之后调用
            (context as Activity).overridePendingTransition(
                R.anim.open_enter,R.anim.open_exit
            )
        }


    }
}