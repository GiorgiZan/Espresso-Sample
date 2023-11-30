package com.example.android.testing.espresso.BasicSample.Steps

import com.example.android.testing.espresso.BasicSample.PageMatchers.SecondPageMatcher
import com.example.android.testing.espresso.BasicSample.getText

object SecondPageMatcherStep {
    fun getShowTextViewText():String{
        return SecondPageMatcher.showTextView.getText()
    }
}