package ru.homework.analyticshomework

import android.app.Application
import ru.homework.analyticshomework.analytics.AppMetricaConfigurator
import ru.homework.analyticshomework.analytics.FirebaseConfigurator
import ru.homework.analyticshomework.data.AnalyticsEnabledConfig


class AnalyticsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        val config = AnalyticsEnabledConfig(
            enabledAnalytics = BuildConfig.ANALYTICS_ENABLED,
            enabledCrashlytics = BuildConfig.CRASHLYTICS_ENABLED
        )

        FirebaseConfigurator.setConfig(applicationContext, config)
        AppMetricaConfigurator.setConfig(this, config)
    }
}