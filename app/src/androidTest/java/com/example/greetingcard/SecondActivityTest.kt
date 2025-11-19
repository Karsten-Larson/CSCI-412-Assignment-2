package com.example.greetingcard

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.Until
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SecondActivityTest {

    private lateinit var device: UiDevice

    @Before
    fun startMainActivityFromHomeScreen() {
        // Initialize UiDevice instance
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

        // Start from the home screen
        device.pressHome()

        // Wait for launcher
        val launcherPackage = device.launcherPackageName
        device.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)), 5000)

        // Launch the app
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        val intent = context.packageManager.getLaunchIntentForPackage(context.packageName)

        context.startActivity(intent)

        // Wait for the app to appear
        device.wait(Until.hasObject(By.pkg(context.packageName).depth(0)), 5000)
    }

    @Test
    fun testStartSecondActivityAndVerifyChallenge() {
        // Click the "start activity explicitly" button
        device.findObject(By.text("Start Activity Explicitly")).click()

        // Wait for the second activity to appear
        device.wait(Until.hasObject(By.text("Device Fragmentation")), 5000)

        // Check that one of the challenges is displayed
        val challengeText = device.findObject(By.textContains("Device Fragmentation"))
        assert(challengeText != null)
    }
}