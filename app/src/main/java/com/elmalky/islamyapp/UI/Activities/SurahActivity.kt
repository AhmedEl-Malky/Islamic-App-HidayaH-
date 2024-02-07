package com.elmalky.islamyapp.UI.Activities

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.elmalky.islamyapp.Util.Constants
import com.elmalky.islamyapp.databinding.ActivitySurahBinding
import java.io.BufferedReader
import java.io.InputStreamReader

class SurahActivity : AppCompatActivity() {
    lateinit var binder: ActivitySurahBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        super.onCreate(savedInstanceState)
        binder = ActivitySurahBinding.inflate(layoutInflater)
        setContentView(binder.root)
        binder.surahContent.movementMethod = ScrollingMovementMethod()
        val surah_num = intent.getIntExtra(Constants.Names.SURAH_NUM, 0)
        val surah_name = intent.getStringExtra(Constants.Names.SURAH_NAME)
        binder.surahName.text = surah_name
        val inputStream = assets.open("${surah_num}.txt")
        val buffer = BufferedReader(InputStreamReader(inputStream))
        var surahContent = buffer.readText()
        binder.surahContent.text = surahContent
        binder.surrahBackBtn.setOnClickListener {
            finish()
        }
    }
}