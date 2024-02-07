package com.elmalky.islamyapp.UI.Fragments

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.elmalky.islamyapp.Util.Constants
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
        var index = 0
        var tasbi7 = Constants.DataManager.tasbi7
        binder.tasbi7Content.text = tasbi7.entries.elementAt(index).key
        var counter = tasbi7.entries.elementAt(index).value
        binder.tasbi7Btn.text = counter.toString()
        binder.apply {
            tasbi7Btn.setOnClickListener {
                startPulse()
                stopPulse()
                counter--
                tasbi7Btn.text = counter.toString()
                if (counter == 0) {
                    if (index == Constants.DataManager.tasbi7.size - 1)
                        index = 0
                    else
                        index++
                    binder.tasbi7Content.text = tasbi7.entries.elementAt(index).key
                    counter = tasbi7.entries.elementAt(index).value
                    binder.tasbi7Btn.text = counter.toString()
                }
            }
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
            binder.pulseAnim.animate().scaleX(1.5f).scaleY(1.5f).alpha(0f).setDuration(600)
                .withEndAction {
                    binder.pulseAnim.scaleX = 1f
                    binder.pulseAnim.scaleY = 1f
                    binder.pulseAnim.alpha = 1f

                }
            handleAnimation.postDelayed(this, 600)
        }
    }

}