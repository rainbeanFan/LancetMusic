package cn.lancetmusic.ui.activity

import android.app.Activity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.IdRes
import cn.lancetmusic.R

/**
 * Created by Lancet at 2022/4/30 22:48
 */
open abstract class BaseActivity: Activity() {

    private var ivBack: ImageView? = null
    private var ivSetting: ImageView? = null

    private var tvTitle: TextView? = null

    open fun <T: View> findView(@IdRes id:Int):T {
        return findViewById(id)
    }

    protected fun initNarBar(showBack:Boolean = false,title:String,showSettings:Boolean = false) {
        ivBack = findView(R.id.back)
        ivSetting = findView(R.id.setting)
        tvTitle = findView(R.id.title)

        if (showBack) {
            ivBack?.visibility = ImageView.VISIBLE
            ivBack?.setOnClickListener {
                finish()
            }
        } else {
            ivBack?.visibility = ImageView.GONE
        }
        if (showSettings) {
            ivSetting?.visibility = ImageView.VISIBLE
            ivSetting?.setOnClickListener {
                finish()
            }
        } else {
            ivSetting?.visibility = ImageView.GONE
        }
        tvTitle?.text = title
    }

}