package com.example.demad.a2msweather.data.domain.commands

interface Command<out T> {
    fun execute(): T
}