package com.elmalky.islamyapp.UI.Activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.elmalky.islamyapp.Adapters.AppViewPagerAdapter
import com.elmalky.islamyapp.Util.Constants
import com.elmalky.islamyapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binder: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binder = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binder.root)
        initViewPager()
    }

    private fun initViewPager() {
        val adapter = AppViewPagerAdapter(this@MainActivity, Constants.Fragments.fragments)
        binder.myViewPager.adapter = adapter
    }
}