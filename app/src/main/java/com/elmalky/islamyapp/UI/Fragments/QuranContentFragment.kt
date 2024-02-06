package com.elmalky.islamyapp.UI.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.elmalky.islamyapp.Adapters.QuranContentAdapter
import com.elmalky.islamyapp.Interfaces.SurahItemInteractions
import com.elmalky.islamyapp.UI.Activities.SurahActivity
import com.elmalky.islamyapp.Util.Constants
import com.elmalky.islamyapp.databinding.FragmentQuranContentBinding


class QuranContentFragment : Fragment(), SurahItemInteractions {
    lateinit var binder: FragmentQuranContentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binder = FragmentQuranContentBinding.inflate(inflater, container, false)
        return binder.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val adapter = QuranContentAdapter(Constants.Content.quranContent, this)
        binder.quranContentRecycler.adapter = adapter
    }

    override fun onItemClickListener(position: Int) {
        var intent = Intent(activity, SurahActivity::class.java)
        intent.putExtra(Constants.Names.SURAH_NUM, position + 1)
        intent.putExtra(Constants.Names.SURAH_NAME, Constants.Content.surahName[position])
        startActivity(intent)
    }

}