package com.example.timerandworker

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

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

        val handler = Handler()
        val thread = Thread {
            handler.post(Runnable {
                Thread.sleep(10000)
                Toast.makeText(context, "From thread ${Thread.currentThread()}", Toast.LENGTH_LONG)
                    .show()
            })
        }

        startTimer.setOnClickListener {
            //Toast.makeText(context, "Starting new Timer", Toast.LENGTH_LONG).show()
            thread.start()
           // startTimer.isEnabled = false
        }

    }
}