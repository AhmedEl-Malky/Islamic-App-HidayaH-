package com.elmalky.islamyapp.UI.Activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.elmalky.islamyapp.Adapters.AzkarMsa2Adapter
import com.elmalky.islamyapp.Interfaces.AzkarItemInteractions
import com.elmalky.islamyapp.Util.Constants
import com.elmalky.islamyapp.databinding.ActivityAzkarMsa2Binding

class AzkarMsa2Activity : AppCompatActivity(), AzkarItemInteractions {
    lateinit var adapter: AzkarMsa2Adapter
    lateinit var binder: ActivityAzkarMsa2Binding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binder = ActivityAzkarMsa2Binding.inflate(layoutInflater)
        setContentView(binder.root)
        adapter = AzkarMsa2Adapter(Constants.DataManager.azkarMsa2m, this)
        binder.apply {
            azkarMsa2BackBtn.setOnClickListener {
                finish()
            }
            azkarMsa2RecyclerView.adapter = adapter
        }
    }

    override fun onItemDeleteListener(position: Int) {
        Constants.DataManager.deleteAzkarMsa2At(position)
        adapter.updateData(Constants.DataManager.azkarMsa2)
    }
}