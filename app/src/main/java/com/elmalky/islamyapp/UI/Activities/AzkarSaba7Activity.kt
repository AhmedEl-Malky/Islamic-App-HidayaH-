package com.elmalky.islamyapp.UI.Activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.elmalky.islamyapp.databinding.ActivityAzkarSaba7Binding

class AzkarSaba7Activity : AppCompatActivity() {
    lateinit var binder: ActivityAzkarSaba7Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binder = ActivityAzkarSaba7Binding.inflate(layoutInflater)
        setContentView(binder.root)
    }
}