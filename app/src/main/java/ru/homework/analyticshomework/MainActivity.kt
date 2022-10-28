package ru.homework.analyticshomework

import androidx.compose.ui.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.homework.analyticshomework.analytics.AnalyticsManager
import ru.homework.analyticshomework.data.AppAnalyticsEvents

class MainActivity : ComponentActivity() {

    val analyticsManager = AnalyticsManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
            ) {
                ButtonsList()
            }
        }
    }

    private fun onButtonClick(strId: Int) {
        when (strId) {
            R.string.login -> login()
            R.string.logout -> logout()
            R.string.send_event -> sendEvent()
            R.string.simulate_crash -> simulateCrash()
            else -> {
                // do nothing
            }
        }
    }

    private fun login() = analyticsManager.setUserId("Test User")

    private fun logout() = analyticsManager.setUserId(null)

    private fun sendEvent() = analyticsManager.sendEvent(AppAnalyticsEvents.BUTTON_PRESSED)

    private fun simulateCrash() = analyticsManager.sendCrash()

    @Composable
    fun ButtonsList() {
        Button(R.string.login)
        Button(R.string.logout)
        Button(R.string.send_event)
        Button(R.string.simulate_crash)
    }

    @Composable
    fun Button(strId: Int) {

        val text = stringResource(id = strId)
        Button(
            onClick = { onButtonClick(strId) },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray),
            modifier = Modifier
                .padding(1.dp)
                .size(300.dp, 60.dp)
                .border(width = 2.dp, Color.Black)
        ) {
            Text(text)
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        ButtonsList()
    }
}

