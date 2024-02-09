package com.elmalky.islamyapp.UI.Activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.elmalky.islamyapp.Adapters.AzkarSaba7Adapter
import com.elmalky.islamyapp.Interfaces.AzkarItemInteractions
import com.elmalky.islamyapp.Util.Constants
import com.elmalky.islamyapp.databinding.ActivityAzkarSaba7Binding

class AzkarSaba7Activity : AppCompatActivity(), AzkarItemInteractions {
    lateinit var adapter: AzkarSaba7Adapter
    lateinit var binder: ActivityAzkarSaba7Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binder = ActivityAzkarSaba7Binding.inflate(layoutInflater)
        setContentView(binder.root)
        adapter = AzkarSaba7Adapter(Constants.DataManager.azkarSaba7m, this)
        binder.apply {
            azkarSaba7BackBtn.setOnClickListener {
                finish()
            }
            azkarSaba7RecyclerView.adapter = adapter
        }
    }

    override fun onItemDeleteListener(position: Int) {
        Constants.DataManager.deleteAzkarSaba7At(position)
        adapter.updateData(Constants.DataManager.azkarSaba7)
    }
}