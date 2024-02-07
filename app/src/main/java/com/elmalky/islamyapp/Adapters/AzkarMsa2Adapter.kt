package com.elmalky.islamyapp.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.elmalky.islamyapp.Interfaces.AzkarItemInteractions
import com.elmalky.islamyapp.R

class AzkarMsa2Adapter(var map: MutableMap<String, Int>, val listener: AzkarItemInteractions) :
    RecyclerView.Adapter<AzkarSaba7Adapter.AzkarItemHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AzkarSaba7Adapter.AzkarItemHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.azkar_item, parent, false)
        return AzkarSaba7Adapter.AzkarItemHolder(view)
    }

    override fun getItemCount() = map.size

    override fun onBindViewHolder(holder: AzkarSaba7Adapter.AzkarItemHolder, position: Int) {
        holder.binder.apply {
            val entry = map.entries.elementAt(position)
            azkarContent.text = entry.key
            azkarCounter.text = entry.value.toString()
            root.setOnClickListener {
                var counter = azkarCounter.text.toString().toInt()
                counter--
                azkarCounter.text = (counter).toString()
                if (counter == 0)
                    listener.onItemDeleteListener(position)
            }
        }
    }

    fun updateData(newMap: MutableMap<String, Int>) {
        map = newMap
        notifyDataSetChanged()
    }
}