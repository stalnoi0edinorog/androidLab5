package com.example.lab3_2

import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
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
    fun startTest() {
        isFirst()
        onView(withId(R.id.bnGoTo2)).perform(click())
        isSecond()
        onView(withId(R.id.bnGoTo1)).perform(click())
        isFirst()
        onView(withId(R.id.bnGoTo2)).perform(click())
        isSecond()
        onView(withId(R.id.bottomNav)).perform(click())
        openBottomNavigation()
        pressBack()
        onView(withId(R.id.bnGoTo3)).perform(click())
        isThird()
        onView(withId(R.id.bnGoTo2)).perform(click())
        isSecond()
    }

    @Test
    fun backstackTest() {
        isFirst()
        onView(withId(R.id.bnGoTo2)).perform(click())
        onView(withId(R.id.bnGoTo3)).perform(click())
        isThird()
        pressBack()
        pressBack()
        isFirst()

        onView(withId(R.id.bnGoTo2)).perform(click())
        onView(withId(R.id.bnGoTo1)).perform(click())
        onView(withId(R.id.bnGoTo2)).perform(click())
        onView(withId(R.id.bnGoTo1)).perform(click())
        pressBackUnconditionally()
    }

    private fun openBottomNavigation() {
        onView(withId(R.id.bnGoTo1)).check((doesNotExist()))
        onView(withId(R.id.bnGoTo2)).check(doesNotExist())
        onView(withId(R.id.bnGoTo3)).check(doesNotExist())
        onView(withId(R.id.textView)).check(matches(withText("Something about activity")))
    }

    private fun isFirst() {
        onView(withId(R.id.bnGoTo1)).check((doesNotExist()))
        onView(withId(R.id.bnGoTo2)).check(matches(isDisplayed()))
        onView(withId(R.id.bnGoTo3)).check(doesNotExist())
        onView(withId(R.id.bottomNav)).check(matches(isDisplayed()))
    }

    private fun isSecond() {
        onView(withId(R.id.bnGoTo1)).check((matches(isDisplayed())))
        onView(withId(R.id.bnGoTo2)).check(doesNotExist())
        onView(withId(R.id.bnGoTo3)).check(matches(isDisplayed()))
        onView(withId(R.id.bottomNav)).check(matches(isDisplayed()))
    }

    private fun isThird() {
        onView(withId(R.id.bnGoTo1)).check((matches(isDisplayed())))
        onView(withId(R.id.bnGoTo2)).check(matches(isDisplayed()))
        onView(withId(R.id.bnGoTo3)).check(doesNotExist())
        onView(withId(R.id.bottomNav)).check(matches(isDisplayed()))
    }
}