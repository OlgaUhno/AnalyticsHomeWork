package ru.homework.analyticshomework.analytics

import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.crashlytics.FirebaseCrashlytics
import ru.homework.analyticshomework.AnalyticsLogger
import ru.homework.analyticshomework.data.AnalyticsEvent

object FirebaseLogger : AnalyticsLogger {
    internal var analytics: FirebaseAnalytics? = null
    internal var crashlytics: FirebaseCrashlytics? = null

    override fun trackEvent(event: AnalyticsEvent, vararg data : Pair<String, String>) {
        val bundle = Bundle().apply {
            for (i in data.indices) {
                putString(data[i].first, data[i].second)
            }
        }
        analytics?.logEvent(event.eventName, bundle)
    }

    override fun setUserId(userId: String?) {
        analytics?.setUserId(userId)
    }

    override fun reportError(e: Exception) {
        throw e
    }
}