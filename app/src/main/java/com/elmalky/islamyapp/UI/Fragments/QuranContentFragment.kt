package com.elmalky.islamyapp.UI.Fragments

import android.content.Context
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

    var surahNum = 1
    override fun onStart() {
        super.onStart()
        var sharedP = requireActivity().getSharedPreferences("SharedPref", Context.MODE_PRIVATE)
        var surahName = sharedP.getString(Constants.Names.SURAH_NAME, "")
        surahNum = sharedP.getInt(Constants.Names.SURAH_NUM, 0)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val adapter = QuranContentAdapter(Constants.DataManager.quranContent, this)
        binder.quranContentRecycler.adapter = adapter
        var sharedP = requireActivity().getSharedPreferences("SharedPref", Context.MODE_PRIVATE)
        var surahName = sharedP.getString(Constants.Names.SURAH_NAME, "")
        surahNum = sharedP.getInt(Constants.Names.SURAH_NUM, 0)
        binder.apply {
            lastSurah.text = surahName
            continueBtn.setOnClickListener {
                var intent = Intent(activity, SurahActivity::class.java)
                intent.putExtra(Constants.Names.SURAH_NUM, surahNum)
                intent.putExtra(
                    Constants.Names.SURAH_NAME,
                    Constants.DataManager.surahName[surahNum - 1]
                )
                startActivity(intent)
            }
        }
    }

    override fun onItemClickListener(position: Int) {
        var intent = Intent(activity, SurahActivity::class.java)
        intent.putExtra(Constants.Names.SURAH_NUM, position + 1)
        intent.putExtra(Constants.Names.SURAH_NAME, Constants.DataManager.surahName[position])
        var sharedP = requireActivity().getSharedPreferences("SharedPref", Context.MODE_PRIVATE)
        var editor = sharedP.edit()
        editor.putString(Constants.Names.SURAH_NAME, Constants.DataManager.surahName[position])
        editor.putInt(Constants.Names.SURAH_NUM, position + 1)
        editor.apply()
        binder.lastSurah.text = Constants.DataManager.surahName[position]
        startActivity(intent)
    }

}