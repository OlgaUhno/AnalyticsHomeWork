package ru.homework.analyticshomework.analytics

import android.app.Application
import android.content.Context
import com.yandex.metrica.YandexMetrica
import com.yandex.metrica.YandexMetricaConfig
import ru.homework.analyticshomework.data.AnalyticsEnabledConfig


internal object AppMetricaConfigurator {
    private const val API_KEY = "cd407e26-8c2f-4671-bf27-59016ae1993f"

    @JvmStatic
    fun setConfig(application: Application, config: AnalyticsEnabledConfig) {
        val configuration = YandexMetricaConfig
            .newConfigBuilder(API_KEY)
            .withLogs()
            .withCrashReporting(config.enabledCrashlytics)
            .withAppOpenTrackingEnabled(true)
            .withNativeCrashReporting(true)
            .withStatisticsSending(true)
            .build()
        YandexMetrica.activate(application.applicationContext, configuration)
        YandexMetrica.enableActivityAutoTracking(application)
    }

    @JvmStatic
    fun resetConfig(context: Context) {
    }
}