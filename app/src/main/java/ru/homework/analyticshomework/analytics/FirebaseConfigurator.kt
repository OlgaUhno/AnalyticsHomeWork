package ru.homework.analyticshomework.analytics

import android.content.Context
import com.google.firebase.FirebaseApp
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.crashlytics.FirebaseCrashlytics
import ru.homework.analyticshomework.data.AnalyticsEnabledConfig

internal object FirebaseConfigurator {
    @JvmStatic
    fun setConfig(context: Context, config: AnalyticsEnabledConfig) {
        FirebaseApp.initializeApp(context)
        FirebaseLogger.analytics = if (config.enabledAnalytics) {
            FirebaseAnalytics.getInstance(context).apply {
                setAnalyticsCollectionEnabled(config.enabledAnalytics)
            }
        } else {
            null
        }
        FirebaseLogger.crashlytics = if (config.enabledCrashlytics) {
            FirebaseCrashlytics.getInstance().apply {
                setCrashlyticsCollectionEnabled(config.enabledAnalytics)
            }
        } else {
            null
        }
    }

    @JvmStatic
    fun resetConfig(context: Context) {
        if (FirebaseLogger.analytics != null) {
            FirebaseAnalytics.getInstance(context).resetAnalyticsData()
        }
    }
}