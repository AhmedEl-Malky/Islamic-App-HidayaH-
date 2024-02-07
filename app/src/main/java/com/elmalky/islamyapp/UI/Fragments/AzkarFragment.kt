package com.elmalky.islamyapp.UI.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.elmalky.islamyapp.UI.Activities.AzkarMsa2Activity
import com.elmalky.islamyapp.UI.Activities.AzkarSaba7Activity
import com.elmalky.islamyapp.databinding.FragmentAzkarBinding

class AzkarFragment : Fragment() {
    lateinit var binder: FragmentAzkarBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binder = FragmentAzkarBinding.inflate(inflater, container, false)
        return binder.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binder.apply {
            azkarSaba7Btn.setOnClickListener {
                val intent = Intent(activity, AzkarSaba7Activity::class.java)
                startActivity(intent)
            }
            azkarMsa2Btn.setOnClickListener {
                val intent = Intent(activity, AzkarMsa2Activity::class.java)
                startActivity(intent)
            }
        }
    }

}