package com.example.octamileappdashboard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import me.relex.circleindicator.CircleIndicator3

class PagerAdapter(var item: MutableList<OnBoarding>, val rContext: Context): RecyclerView.Adapter<PagerAdapter.ViewHolder>() {
//    private lateinit var viewPagerDotsIndicator:

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val amount = view.findViewById<TextView>(R.id.value_tv)
        val certificateChanges = view.findViewById<TextView>(R.id.all_certificate_tv )
        val viewPagerDotsIndicator = view.findViewById<CircleIndicator3>(R.id.indicator)


        fun bindView(items: OnBoarding){
            amount.text = items.figure.toString()
            certificateChanges.text = items.cert.toString()
            setUpIndicator(viewPagerDotsIndicator)
            isCurrentIndicator(adapterPosition,viewPagerDotsIndicator)

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val itemView = LayoutInflater.from(parent.context).inflate(R.layout.onboarding_viewpager_layout,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      holder.bindView(item[position])
//        isCurrentIndicator(position,)
    }

    override fun getItemCount(): Int {
       return item.size
    }
    //Set up indicator
    private fun setUpIndicator(viewPagerDotsIndicator:CircleIndicator3) {
        val indicator = arrayOfNulls<ImageView>(itemCount)
        val layoutParams: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        layoutParams.setMargins(12, 0, 12, 8)

        for (eachCircle in indicator.indices) {
            indicator[eachCircle] = ImageView(rContext)
            indicator[eachCircle]?.let {
                it.setImageDrawable(
                    this.let { context ->
                        ContextCompat.getDrawable(
                            rContext, R.drawable.circle_indicator
                        )
                    }
                )
                it.layoutParams = layoutParams
                viewPagerDotsIndicator.addView(it)
            }
        }
    }

    //set the indicator light to the current page
    fun isCurrentIndicator(position: Int,viewPagerDotsIndicator:CircleIndicator3) {
        val childCount = viewPagerDotsIndicator.childCount

        for (spot in 0 until childCount) {
            val view = viewPagerDotsIndicator.getChildAt(spot) as ImageView
            if (spot == position) {
                view.setImageDrawable(
                    this.let {
                        ContextCompat.getDrawable(rContext, R.drawable.current_position_indicator)
                    }
                )
            } else {
                view.setImageDrawable(
                    this.let {
                        ContextCompat.getDrawable(rContext, R.drawable.circle_indicator)
                    }
                )
            }
        }
    }


}