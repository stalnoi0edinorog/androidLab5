package com.example.lab5


import android.content.pm.ActivityInfo
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val activityTestRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun mainActivityTest() {
        val changeB = onView(withId(R.id.changeButton))
        val editT = onView(withId(R.id.editText))

        editT.check(ViewAssertions.matches(withText("Winter")))
        changeB.check(ViewAssertions.matches(withText("November")))
        changeB.perform(click())
        changeB.check(ViewAssertions.matches(withText("December")))

        //Thread.sleep(1000)
        activityTestRule.scenario.onActivity{
            it.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        }
        //Thread.sleep(1000)
        editT.check(ViewAssertions.matches(withText("Winter")))
        changeB.check(ViewAssertions.matches(withText("November")))
    }



}
