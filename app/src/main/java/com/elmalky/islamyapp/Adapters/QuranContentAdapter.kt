package com.elmalky.islamyapp.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.elmalky.islamyapp.Interfaces.SurahItemInteractions
import com.elmalky.islamyapp.R
import com.elmalky.islamyapp.databinding.SurahItemBinding

class QuranContentAdapter(val quranContent: List<String>, val listener: SurahItemInteractions) :
    RecyclerView.Adapter<QuranContentAdapter.SurahItemHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SurahItemHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.surah_item, parent, false)
        return SurahItemHolder(view)
    }

    override fun getItemCount() = quranContent.size

    override fun onBindViewHolder(holder: SurahItemHolder, position: Int) {
        holder.binder.apply {
            surahName.text = quranContent[position]
            surahNum.text = (position + 1).toString()
            root.setOnClickListener {
                listener.onItemClickListener(position)
            }
        }
    }

    class SurahItemHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binder = SurahItemBinding.bind(view)
    }
}