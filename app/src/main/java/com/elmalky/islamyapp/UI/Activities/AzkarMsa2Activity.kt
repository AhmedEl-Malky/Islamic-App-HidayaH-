package com.elmalky.islamyapp.UI.Activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.elmalky.islamyapp.databinding.ActivityAzkarMsa2Binding

class AzkarMsa2Activity : AppCompatActivity() {
    lateinit var binder: ActivityAzkarMsa2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binder = ActivityAzkarMsa2Binding.inflate(layoutInflater)
        setContentView(binder.root)
    }
}