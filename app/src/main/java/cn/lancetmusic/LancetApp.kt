package cn.lancetmusic

import android.app.Application
import com.blankj.utilcode.util.Utils
import io.realm.Configuration
import io.realm.Realm

/**
 * Created by Lancet at 2022/4/30 22:42
 */
class LancetApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Utils.init(this)
    }

}