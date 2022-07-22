package cn.lancetmusic.ui.activity

import android.os.Bundle
import cn.lancetmusic.R

class AlbumListActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album_list)

        initView()

    }

    private fun initView() {
        initNarBar(showBack = true,"专辑列表")

    }

}