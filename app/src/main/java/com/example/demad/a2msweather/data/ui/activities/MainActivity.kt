package com.example.demad.a2msweather.data.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demad.a2msweather.data.domain.commands.RequestForecastCommand
import com.example.demad.a2msweather.data.ui.adapters.ForecastListAdapter
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import com.example.demad.a2msweather.R
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.uiThread


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        forecastList.layoutManager = LinearLayoutManager(this)
        doAsync {
            val result = RequestForecastCommand("94043").execute()
            uiThread {
                val adapter = ForecastListAdapter(result) { toast(it.date) }
                forecastList.adapter = adapter
            }
        }
    }
}