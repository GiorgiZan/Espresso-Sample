package com.example.android.testing.espresso.BasicSample.Steps

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.clearText
import com.example.android.testing.espresso.BasicSample.PageMatchers.MainPageMatcher
import com.example.android.testing.espresso.BasicSample.getText
import com.example.android.testing.espresso.BasicSample.tap
import com.example.android.testing.espresso.BasicSample.typeText


object MainPageMatcherStep {
    fun typeText(text: String){
        MainPageMatcher.editTextUserInput.typeText(text)
    }
    fun pressChangeTextButton(){
        MainPageMatcher.changeTextBtn.tap()
    }
    fun pressOpenAndChangeTextButton(){
        MainPageMatcher.activityChangeTextBtn.tap()
    }
    fun getTextToBeChangedText():String{
        return MainPageMatcher.textToBeChanged.getText()
    }
    fun textClear(){
        onView(MainPageMatcher.editTextUserInput).perform(clearText())
    }
}