package com.greg.albumandgalleryfromapi

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.greg.albumandgalleryfromapi.ui.activities.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ActivityInstrumentedTest {

    @get:Rule
    var rule: ActivityScenarioRule<*> = ActivityScenarioRule(MainActivity::class.java)

    private fun delayer() {
        try {
            Thread.sleep(2000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }

    @Test
    fun goToGalleryActivity_andCheckGalleryRecyclerView_isDisplayed(){
        onView(withId(R.id.album_recycler_view))
            delayer()
        onView(withId(R.id.album_recycler_view)).perform(click())
        onView(withId(R.id.gallery_recycler_view))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun goBackToMainActivity_clickingOnBackPress(){
        onView(withId(R.id.album_recycler_view))
        delayer()
        onView(withId(R.id.album_recycler_view)).perform(click())
        onView(withId(R.id.gallery_recycler_view))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        pressBack()
    }
}