package cn.lancetmusic.helper

import android.content.Context
import android.media.MediaPlayer
import android.net.Uri
import kotlin.properties.Delegates

/**
 * Created by Lancet at 2022/5/3 22:11
 */
class MediaPlayerHelper private constructor() {

    private var listener: OnMediaPlayerHelperListener by Delegates.notNull()

    companion object {

        private var mContext: Context by Delegates.notNull()

        private var mMediaPlayer: MediaPlayer by Delegates.notNull()


        private var mPath: String?=null

        @Volatile
        private var instance: MediaPlayerHelper? = null

        fun getInstance(context: Context): MediaPlayerHelper {
            return when {
                instance != null -> instance!!
                else -> synchronized(this) {
                    if (instance == null) {
                        mContext = context
                        mMediaPlayer = MediaPlayer()
                        instance = MediaPlayerHelper()
                    }
                    instance!!
                }
            }
        }

    }


    fun setPath(path: String) {
        mPath = path
        if (mMediaPlayer.isPlaying) {
            mMediaPlayer.reset()
        }
        mMediaPlayer.setDataSource(Companion.mContext, Uri.parse(path))
        mMediaPlayer.prepareAsync()
        mMediaPlayer.setOnPreparedListener {
            listener?.onPrepared(it)
        }

    }

    fun getPath(): String? {
        return mPath
    }

    fun play() {
        if (mMediaPlayer.isPlaying) return
        mMediaPlayer.start()
    }

    fun pause() {
        if (mMediaPlayer.isPlaying) {
            mMediaPlayer.pause()
        }
    }

    fun setOnPreparedListener(listener: OnMediaPlayerHelperListener) {
        this.listener = listener
    }

    interface OnMediaPlayerHelperListener{
        fun onPrepared(mediaPlayer: MediaPlayer)
    }

}