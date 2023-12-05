package com.example.android.testing.espresso.BasicSample.Tests

import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.android.testing.espresso.BasicSample.Data.Data
import com.example.android.testing.espresso.BasicSample.MainActivity
import com.example.android.testing.espresso.BasicSample.PageMatchers.MainPageMatcher
import com.example.android.testing.espresso.BasicSample.PageMatchers.SecondPageMatcher
import com.example.android.testing.espresso.BasicSample.Steps.MainPageMatcherStep
import com.example.android.testing.espresso.BasicSample.Steps.SecondPageMatcherStep
import com.example.android.testing.espresso.BasicSample.getText
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@LargeTest
class ChangeTextTests {

    @get:Rule
    var activityScenarioRule = activityScenarioRule<MainActivity>()

    @Test
    fun checkFullNameTest(){
        with(MainPageMatcherStep){
            typeText(Data.fullNameText)
            pressChangeTextButton()
            Assert.assertEquals(Data.fullNameText, getTextToBeChangedText())
        }
    }

    @Test
    fun checkFavMovieNameTest(){
        with(MainPageMatcherStep){
            typeText(Data.favMovieName)
            pressChangeTextButton()
            Assert.assertEquals(Data.favMovieName, getTextToBeChangedText())
            textClear()
            typeText(Data.secondFavMovieName)
            pressOpenAndChangeTextButton()
            Assert.assertEquals(Data.secondFavMovieName, SecondPageMatcherStep.getShowTextViewText())
        }
    }
}