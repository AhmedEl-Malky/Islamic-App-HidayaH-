package com.elmalky.islamyapp.UI.Activities

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.elmalky.islamyapp.Adapters.AppViewPagerAdapter
import com.elmalky.islamyapp.R
import com.elmalky.islamyapp.Util.Constants
import com.elmalky.islamyapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binder: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        super.onCreate(savedInstanceState)
        binder = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binder.root)
        initViewPager()
        binder.myViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> binder.mainBottomNav.selectedItemId = R.id.quran_fragment
                    1 -> binder.mainBottomNav.selectedItemId = R.id.sib7a_fragment
                    2 -> binder.mainBottomNav.selectedItemId = R.id.azkar_fragment
                    3 -> binder.mainBottomNav.selectedItemId = R.id.radio_fragment
                }
                super.onPageSelected(position)
            }
        })
        binder.mainBottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.quran_fragment -> {
                    binder.myViewPager.currentItem = 0
                    true
                }

                R.id.sib7a_fragment -> {
                    binder.myViewPager.currentItem = 1
                    true
                }

                R.id.azkar_fragment -> {
                    binder.myViewPager.currentItem = 2
                    true
                }

                R.id.radio_fragment -> {
                    binder.myViewPager.currentItem = 3
                    true
                }

                else -> false
            }
        }
    }

    private fun initViewPager() {
        val adapter = AppViewPagerAdapter(this@MainActivity, Constants.Fragments.fragments)
        binder.myViewPager.adapter = adapter
    }
}