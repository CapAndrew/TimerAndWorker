package com.example.timerandworker

import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.TextView


class TimerHandlerThread constructor(_textView: TextView) : Thread() {

    private val textView : TextView = _textView
    var handler = Handler(Looper.getMainLooper())

    override fun run() {
        var secondsCounter = 0
        var formatTime: String

        while (true) {
            formatTime = convertCounterIntoFormatTime(secondsCounter)

            handler.post {
                textView.text = formatTime
                Log.i("TimerTick", "Now count = $formatTime")
            }

            sleep(1000)
            secondsCounter++
        }
    }

    private fun convertCounterIntoFormatTime(counter: Int): String{
        var formatSeconds = "0"
        var formatMinutes = "0"

        if (counter % 60 < 10) {
            formatSeconds = "0${counter % 60}"
        } else if (counter % 60 in 10..60) {
            formatSeconds = "${counter % 60}"
        }

        if (counter / 60 < 10) {
            formatMinutes = "0${counter / 60}"
        } else if (counter / 60 in 10..60) {
            formatMinutes = "${counter / 60}"
        }
        return "$formatMinutes:$formatSeconds"
    }
}