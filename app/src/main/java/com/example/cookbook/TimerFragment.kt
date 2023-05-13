package com.example.cookbook

import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView


class TimerFragment : Fragment(), View.OnClickListener {
    private var seconds = 0
    private var running = false
    private var wasRunning = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            seconds = savedInstanceState.getInt("seconds")
            running = savedInstanceState.getBoolean("running")
            wasRunning = savedInstanceState.getBoolean("wasRunning")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val layout = inflater.inflate(R.layout.fragment_timer, container, false)
        runTimer(layout)
        val startBtn: Button = layout.findViewById(R.id.start_button) as Button
        val stopBtm: Button = layout.findViewById(R.id.stop_button) as Button
        val resetBtn: Button = layout.findViewById(R.id.reset_button) as Button

        startBtn.setOnClickListener(this)
        stopBtm.setOnClickListener(this)
        resetBtn.setOnClickListener(this)
        return layout
    }

    override fun onPause() {
        super.onPause()
        wasRunning = running
        running = false
    }

    override fun onResume() {
        super.onResume()
        if (wasRunning) { running = true }
    }

    private fun onClickStart() { running = true }
    private fun onClickStop() { running = false }
    private fun onClickReset() {
        running = false
        seconds = arguments?.getInt("time") ?: 0
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("seconds", seconds)
        outState.putBoolean("running", running)
        outState.putBoolean("wasRunning", wasRunning)
    }

    private fun runTimer(view: View) {
        val timeView: TextView = view.findViewById<View>(R.id.timer_view) as TextView
        val handler: Handler = Handler()
        if(seconds == 0){
            seconds = arguments?.getInt("time") ?: 0
        }
        handler.post(object : Runnable {
            override fun run() {
                val hours = seconds / 3600
                val minutes = seconds % 3600 / 60
                val secs = seconds % 60
                val time = String.format("%d:%02d:%02d", hours, minutes, secs)
                timeView.text = time
                if (running && seconds > 0) {
                    seconds--
                }
                handler.postDelayed(this, 1000)
            }
        })
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.start_button -> onClickStart()
            R.id.stop_button -> onClickStop()
            R.id.reset_button -> onClickReset()
        }
    }
}
