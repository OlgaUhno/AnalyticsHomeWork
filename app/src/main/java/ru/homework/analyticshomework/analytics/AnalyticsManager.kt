package ru.homework.analyticshomework.analytics

import ru.homework.analyticshomework.data.AnalyticsEvent
import java.text.DateFormat
import java.util.*

class AnalyticsManager {

    private val loggers = arrayListOf(FirebaseLogger, AppMetricaLogger)

    fun sendEvent(event: AnalyticsEvent) {
        loggers.onEach {
            it.trackEvent(event)
        }
    }

    fun sendCrash() {
        loggers.onEach {
            it.reportError(RuntimeException(
                "Application crashed:" + DateFormat.getDateTimeInstance().format(Date())
            ))
        }
    }

    fun setUserId(userId: String?) {
        loggers.onEach {
            it.setUserId(userId)
        }
    }
}