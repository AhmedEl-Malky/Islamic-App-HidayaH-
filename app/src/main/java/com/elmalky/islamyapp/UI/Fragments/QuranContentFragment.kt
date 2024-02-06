package com.elmalky.islamyapp.UI.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.elmalky.islamyapp.Adapters.QuranContentAdapter
import com.elmalky.islamyapp.Util.Constants
import com.elmalky.islamyapp.databinding.FragmentQuranContentBinding


class QuranContentFragment : Fragment() {
    lateinit var binder: FragmentQuranContentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binder = FragmentQuranContentBinding.inflate(inflater, container, false)
        return binder.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val adapter = QuranContentAdapter(Constants.Content.quranContent)
        binder.quranContentRecycler.adapter = adapter
    }

}