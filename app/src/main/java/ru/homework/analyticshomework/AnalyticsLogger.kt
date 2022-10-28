package ru.homework.analyticshomework

import ru.homework.analyticshomework.data.AnalyticsEvent

interface AnalyticsLogger {
    fun trackEvent(event: AnalyticsEvent, vararg data : Pair<String, String>)
    fun setUserId(userId: String?)
    fun reportError(e: Exception)
}