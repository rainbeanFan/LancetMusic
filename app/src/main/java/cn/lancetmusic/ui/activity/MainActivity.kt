package cn.lancetmusic.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import cn.lancetmusic.R
import cn.lancetmusic.adapter.HotAdapter
import cn.lancetmusic.adapter.RecommendationAdapter
import cn.lancetmusic.adapter.ViewPagerAdapter
import cn.lancetmusic.ui.widget.GridSpaceItemDecoration
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlin.properties.Delegates

class MainActivity : BaseActivity() {

    private var setting by Delegates.notNull<ImageView>()

    private var recommendation by Delegates.notNull<RecyclerView>()
    private var hot by Delegates.notNull<RecyclerView>()

    private var mAdapter: RecommendationAdapter by Delegates.notNull()
    private var mHotAdapter: HotAdapter by Delegates.notNull()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    private fun initView() {
        initNarBar(title = "Lancet Music", showSettings = true)

        setting = findViewById(R.id.setting)

        setting.setOnClickListener {
            startActivity(Intent(this, MineActivity::class.java))
        }
        recommendation = findView(R.id.rv_recommendation)
        hot = findView(R.id.rv_hot)

        mAdapter = RecommendationAdapter(this)
        mHotAdapter = HotAdapter(this,hot)

        val gridSpace = GridSpaceItemDecoration(4, recommendation)
        recommendation.apply {
            isNestedScrollingEnabled = false
            layoutManager = GridLayoutManager(this@MainActivity,3)
            adapter = mAdapter
        }
        recommendation.addItemDecoration(gridSpace)

        hot.apply {
            isNestedScrollingEnabled = false
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = mHotAdapter
        }
        hot.addItemDecoration(DividerItemDecoration(this@MainActivity,DividerItemDecoration.VERTICAL))

    }
}