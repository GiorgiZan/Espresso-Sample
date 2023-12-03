package com.example.android.testing.espresso.BasicSample


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.core.IsInstanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class RecordedEspressoTest {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun mainActivityTest() {
        val editText = onView(
            allOf(
                withId(R.id.editTextUserInput),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        editText.perform(replaceText("Kino kritikosi"), closeSoftKeyboard())

        val button = onView(
            allOf(
                withId(R.id.changeTextBt), withText("Change text"),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        button.perform(click())

        val textView = onView(
            allOf(
                withId(R.id.textToBeChanged), withText("Kino kritikosi"),
                withParent(withParent(withId(android.R.id.content))),
                isDisplayed()
            )
        )
        textView.check(matches(withText("Kino kritikosi")))

        val editText2 = onView(
            allOf(
                withId(R.id.editTextUserInput), withText("Kino kritikosi"),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        editText2.perform(click())

        val editText3 = onView(
            allOf(
                withId(R.id.editTextUserInput), withText("Kino kritikosi"),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        editText3.perform(replaceText(""))

        val editText4 = onView(
            allOf(
                withId(R.id.editTextUserInput),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        editText4.perform(closeSoftKeyboard())

        val editText5 = onView(
            allOf(
                withId(R.id.editTextUserInput),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        editText5.perform(click())

        val editText6 = onView(
            allOf(
                withId(R.id.editTextUserInput),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        editText6.perform(replaceText("Cnobili poeti"), closeSoftKeyboard())

        val button2 = onView(
            allOf(
                withId(R.id.activityChangeTextBtn), withText("Open activity and change text"),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    3
                ),
                isDisplayed()
            )
        )
        button2.perform(click())

        val textView2 = onView(
            allOf(
                withId(R.id.show_text_view), withText("Cnobili poeti"),
                withParent(
                    allOf(
                        withId(android.R.id.content),
                        withParent(IsInstanceOf.instanceOf(android.view.ViewGroup::class.java))
                    )
                ),
                isDisplayed()
            )
        )
        textView2.check(matches(withText("Cnobili poeti")))
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
