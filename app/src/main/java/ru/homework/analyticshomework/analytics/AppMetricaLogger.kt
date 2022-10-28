package ru.homework.analyticshomework.analytics

import com.yandex.metrica.YandexMetrica
import ru.homework.analyticshomework.AnalyticsLogger
import ru.homework.analyticshomework.data.AnalyticsEvent

object AppMetricaLogger : AnalyticsLogger {

    override fun trackEvent(event: AnalyticsEvent, vararg data : Pair<String, String>) {
        YandexMetrica.reportEvent(event.eventName)
    }

    override fun setUserId(userId: String?) {
        YandexMetrica.setUserProfileID(userId)
    }

    override fun reportError(e: Exception) {
        YandexMetrica.reportError(e.message ?: "", e)
    }
}