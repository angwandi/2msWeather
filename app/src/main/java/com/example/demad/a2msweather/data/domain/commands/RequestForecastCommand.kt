package com.example.demad.a2msweather.data.domain.commands

import com.example.demad.a2msweather.data.data.ForecastRequest
import com.example.demad.a2msweather.data.domain.mappers.ForecastDataMapper
import com.example.demad.a2msweather.data.domain.model.ForecastList

class RequestForecastCommand(private val zipCode: String) : Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }
}