package com.example.demad.a2msweather.data.data

import android.util.Log
import java.net.URL

//could use Retrofit for this, this is enough for my case for now
/*
The implementation is straightforward when using readText , an extension function from the Kotlin standard library.
This method is not recommended for large responses, but it is good enough in my case.
*/
class Request(private val url: String) {
    fun run() {
        val forecastJsonStr = URL(url).readText()
        Log.d(javaClass.simpleName, forecastJsonStr)
    }
}