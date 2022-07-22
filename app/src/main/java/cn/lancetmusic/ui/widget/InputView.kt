package cn.lancetmusic.ui.widget

import android.content.Context
import android.text.InputType
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.ImageView
import cn.lancetmusic.R
import kotlin.properties.Delegates

/**
 * Created by Lancet at 2022/5/1 19:59
 */
class InputView : FrameLayout {

    private var inputIcon by Delegates.notNull<Int>()
    private var inputHint by Delegates.notNull<String>()

    private var isPassword  = false

    private var view by Delegates.notNull<View>()
    private var icon by Delegates.notNull<ImageView>()
    private var input by Delegates.notNull<EditText>()

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleRes: Int) : super(
        context,
        attrs,
        defStyleRes
    ){
        init(context, attrs)
    }

    private fun init(context:Context, attrs: AttributeSet?){
        if (attrs == null) return
        context.obtainStyledAttributes(attrs,R.styleable.InputView).run {

            inputIcon = getResourceId(R.styleable.InputView_input_icon,R.drawable.ic_baseline_music_note_24)

            inputHint = getString(R.styleable.InputView_input_hint)?:"请输入"

            isPassword = getBoolean(R.styleable.InputView_is_password,false)

            recycle()
        }

        view = LayoutInflater.from(context).inflate(R.layout.layout_input_view,this,false)
        icon = view.findViewById(R.id.iv_input_icon)
        input = view.findViewById(R.id.et_input)

        icon?.setImageResource(inputIcon)
        input?.hint = inputHint
        input?.inputType = if (isPassword) {
            InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
        } else {
            InputType.TYPE_CLASS_PHONE
        }

        addView(view)
    }

    public fun getInputStr():String{
        return input.text.toString().trim()
    }

}