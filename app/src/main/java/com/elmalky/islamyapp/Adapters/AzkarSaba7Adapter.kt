package com.elmalky.islamyapp.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.elmalky.islamyapp.Interfaces.AzkarItemInteractions
import com.elmalky.islamyapp.R
import com.elmalky.islamyapp.databinding.AzkarItemBinding

class AzkarSaba7Adapter(var map: MutableMap<String, Int>, val listener: AzkarItemInteractions) :
    RecyclerView.Adapter<AzkarSaba7Adapter.AzkarItemHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AzkarSaba7Adapter.AzkarItemHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.azkar_item, parent, false)
        return AzkarItemHolder(view)
    }

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

    override fun getItemCount() = map.size
    fun updateData(newMap: MutableMap<String, Int>) {
        map = newMap
        notifyDataSetChanged()
    }

    class AzkarItemHolder(view: View) : RecyclerView.ViewHolder(view) {
        var binder = AzkarItemBinding.bind(view)
    }

}