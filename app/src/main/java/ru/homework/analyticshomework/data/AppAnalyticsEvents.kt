package ru.homework.analyticshomework.data

enum class AppAnalyticsEvents(override val eventName: String)  : AnalyticsEvent {
    BUTTON_PRESSED("button_pressed")
}