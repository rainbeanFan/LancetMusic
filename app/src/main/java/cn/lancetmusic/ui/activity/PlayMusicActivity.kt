package cn.lancetmusic.ui.activity

import android.os.Bundle
import android.view.WindowManager
import android.widget.ImageView
import cn.lancetmusic.R
import cn.lancetmusic.ui.widget.PlayMusicView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import jp.wasabeef.glide.transformations.BlurTransformation
import kotlin.properties.Delegates

class PlayMusicActivity : BaseActivity() {

    private var playMusicView: PlayMusicView by Delegates.notNull()

    private val url =
        "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fcuimianxinli.com%2Fupload%2F2016-07%2F16072613412794.jpg&refer=http%3A%2F%2Fcuimianxinli.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1654150276&t=393628420414c371b4b00540943cf0c7"

    private var musicUrl = "https://ydlvideo.ydl.com/sv/277e9b2c-18119a076e0/277e9b2c-18119a076e0.mp3?auth_key\u003d1653996298-f2801b7f4b214c6899ee834427cfb6e5-0-f0b59beeb95ed26f922ee530fcb7cde2"
//    private var musicUrl = "https://storage.googleapis.com/exoplayer-test-media-0/play.mp3"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_music)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        initView()
    }

    private fun initView() {
        findView<ImageView>(R.id.iv_back).setOnClickListener {
            onBackPressed()
        }

        val ivBG = findView<ImageView>(R.id.iv_bg)

        playMusicView = findView(R.id.play_music_view)

        Glide.with(this)
            .load(url)
            .apply(RequestOptions.bitmapTransform(BlurTransformation(25, 10)))
            .into(ivBG)

        playMusicView.setMusicIcon(url)
        playMusicView.startPlayMusic(musicUrl)

    }

}