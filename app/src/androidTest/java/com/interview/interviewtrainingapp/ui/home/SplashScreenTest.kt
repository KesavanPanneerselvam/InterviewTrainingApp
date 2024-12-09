package com.interview.interviewtrainingapp.ui.home

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.interview.interviewtrainingapp.ui.splash.SplashScreen
import com.interview.interviewtrainingapp.ui.theme.InterviewTrainingAppTheme
import org.junit.Rule
import org.junit.Test

class SplashScreenTest {

    @get:Rule val composeTestRule = createComposeRule()
    // use createAndroidComposeRule<YourActivity>() if you need access to
    // an activity

    @Test
    fun myTest() {
        // Start the app
        composeTestRule.setContent {
            InterviewTrainingAppTheme {
                SplashScreen{}
            }
        }

        composeTestRule.onNodeWithText("Splash Screen").assertIsDisplayed()
    }
}