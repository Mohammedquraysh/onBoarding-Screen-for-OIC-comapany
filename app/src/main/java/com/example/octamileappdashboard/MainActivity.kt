package com.example.octamileappdashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator
import me.relex.circleindicator.CircleIndicator
import me.relex.circleindicator.CircleIndicator3

class MainActivity : AppCompatActivity() {
    private lateinit var onBoardingAdapter: MutableList<OnBoarding>
    private lateinit var viewPagerAdapter: PagerAdapter
    private lateinit var viewPagerLayout: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPagerLayout = findViewById(R.id.viewPager2)


//        onBoardingAdapter = mutableListOf(OnBoarding(3, "insureyour "),
//            OnBoarding(9, " Insurance"),
//            OnBoarding(4, "comprehensive")
//        )
//        viewPagerAdapter = PagerAdapter(onBoardingAdapter)
//        viewPagerLayout.adapter = viewPagerAdapter
        setUpOnBoardingPage()
//        setUpIndicator()
    }



    private fun setUpOnBoardingPage(){

        onBoardingAdapter = mutableListOf(OnBoarding(3, "insureyour "),
            OnBoarding(9, " Insurance"),
            OnBoarding(4, "comprehensive")
        )
       viewPagerAdapter = PagerAdapter(onBoardingAdapter,this)
        viewPagerLayout.adapter = viewPagerAdapter


        viewPagerAdapter.item = onBoardingAdapter

        viewPagerLayout.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
//                isCurrentIndicator(position)
//                textChangeOnClickEvent(position)
//                onClickChangeViewEvent(position)
            }

        })
        (viewPagerLayout.getChildAt(0) as RecyclerView).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
    }

    }