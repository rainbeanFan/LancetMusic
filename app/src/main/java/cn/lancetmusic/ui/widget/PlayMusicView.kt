package cn.lancetmusic.ui.widget

import android.annotation.SuppressLint
import android.content.Context
import android.media.MediaPlayer
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.FrameLayout
import android.widget.ImageView
import cn.lancetmusic.R
import cn.lancetmusic.helper.MediaPlayerHelper
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView
import kotlin.properties.Delegates

/**
 * Created by Lancet at 2022/5/3 14:13
 */
class PlayMusicView : FrameLayout {

    private var ivIcon: CircleImageView by Delegates.notNull()
    private var playMusicLayout: FrameLayout by Delegates.notNull()
    private var ivNeedle: ImageView by Delegates.notNull()
    private var ivPlay: ImageView by Delegates.notNull()

    private var mPlayMusicAnim: Animation by Delegates.notNull()
    private var mPlayNeedleAnim: Animation by Delegates.notNull()
    private var mStopNeedleAnim: Animation by Delegates.notNull()

    private var isPlaying: Boolean = false

    private var mediaPlayerHelper: MediaPlayerHelper by Delegates.notNull()

    private var mPath = ""

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(
        context: Context,
        attrs: AttributeSet?,
        defStyleAttr: Int
    ) : super(context, attrs, defStyleAttr) {
        init(context)
    }


    @SuppressLint("MissingInflatedId")
    private fun init(context: Context) {

        val view = LayoutInflater.from(context).inflate(R.layout.layout_play_music, this, false)

        ivIcon = view.findViewById(R.id.iv_music_icon)

        playMusicLayout = view.findViewById(R.id.fl_layout)
        ivNeedle = view.findViewById(R.id.iv_needle)
        ivPlay = view.findViewById(R.id.iv_play)

        playMusicLayout.setOnClickListener {
            trigger()
        }

        mPlayMusicAnim = AnimationUtils.loadAnimation(context, R.anim.play_music)
        mPlayNeedleAnim = AnimationUtils.loadAnimation(context, R.anim.play_needle)
        mStopNeedleAnim = AnimationUtils.loadAnimation(context, R.anim.stop_needle)
        addView(view)

        mediaPlayerHelper = MediaPlayerHelper.getInstance(context)

    }

    fun setMusicIcon(url: String) {
        Glide.with(context)
            .load(url)
            .into(ivIcon)

    }

    fun startPlayMusic(path: String) {
        mPath = path
        isPlaying = true
        ivPlay.visibility = GONE
        playMusicLayout.startAnimation(mPlayMusicAnim)
        ivNeedle.startAnimation(mPlayNeedleAnim)

        if (mediaPlayerHelper.getPath() !=null &&  mediaPlayerHelper.getPath() == path) {
            mediaPlayerHelper.play()
        } else {
            mediaPlayerHelper.setPath(path)
            mediaPlayerHelper.setOnPreparedListener(object:MediaPlayerHelper.OnMediaPlayerHelperListener{
                override fun onPrepared(mediaPlayer: MediaPlayer) {
                    mediaPlayerHelper.play()
                }
            })
        }

    }

    private fun stopPlayMusic() {
        isPlaying = false
        ivPlay.visibility = VISIBLE
        playMusicLayout.animation.cancel()
        playMusicLayout.clearAnimation()
        ivNeedle.startAnimation(mStopNeedleAnim)

        mediaPlayerHelper.pause()
    }

    private fun trigger() {
        if (isPlaying) {
            stopPlayMusic()
        } else {
            startPlayMusic(mPath)
        }
    }

}
