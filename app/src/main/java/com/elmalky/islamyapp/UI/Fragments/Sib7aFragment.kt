package com.elmalky.islamyapp.UI.Fragments

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.elmalky.islamyapp.databinding.FragmentSib7aBinding


class Sib7aFragment : Fragment() {
    private var handleAnimation = Handler()
    lateinit var binder: FragmentSib7aBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binder = FragmentSib7aBinding.inflate(inflater, container, false)
        return binder.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binder.tasbi7Btn.setOnClickListener {
            startPulse()
            stopPulse()
//            TODO("Counter Functionality")
        }
    }

    private fun startPulse() {
        runnable.run()
    }

    private fun stopPulse() {
        handleAnimation.removeCallbacks(runnable)
    }

    private var runnable = object : Runnable {
        override fun run() {
            binder.pulseAnim.animate().scaleX(2f).scaleY(2f).alpha(0f).setDuration(600)
                .withEndAction {
                    binder.pulseAnim.scaleX = 1f
                    binder.pulseAnim.scaleY = 1f
                    binder.pulseAnim.alpha = 1f

                }
            handleAnimation.postDelayed(this, 600)
        }
    }

}