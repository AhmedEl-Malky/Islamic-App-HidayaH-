package com.elmalky.islamyapp.UI.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.elmalky.islamyapp.databinding.FragmentQuranContentBinding


class QuranContentFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binder = FragmentQuranContentBinding.inflate(inflater, container, false)
        return binder.root
    }

}