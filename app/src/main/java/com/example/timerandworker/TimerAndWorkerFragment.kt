package com.example.timerandworker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.timer_and_worker_fragment.*

class TimerAndWorkerFragment : Fragment() {

    companion object {
        fun newInstance() = TimerAndWorkerFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.timer_and_worker_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        someButton.setOnClickListener {
            val timer2 = TimerHandlerThread(someText)
            timer2.start()
            someButton.isEnabled = false
        }

        startTimer.setOnClickListener {
            val timer = TimerHandlerThread(time)
            timer.start()
            startTimer.isEnabled = false
        }
    }
}