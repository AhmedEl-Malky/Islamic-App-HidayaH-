package com.elmalky.islamyapp.UI.Activities

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.appcompat.app.AppCompatActivity
import com.elmalky.islamyapp.databinding.ActivitySurahBinding

class SurahActivity : AppCompatActivity() {
    lateinit var binder: ActivitySurahBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binder = ActivitySurahBinding.inflate(layoutInflater)
        setContentView(binder.root)
        binder.surahContent.movementMethod = ScrollingMovementMethod()
    }
}