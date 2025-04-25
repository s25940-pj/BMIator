package com.example.bmiator;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.ext.junit.rules.ActivityScenarioRule;


import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;

@RunWith(AndroidJUnit4.class)
public class MainActivityEspressoTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testBmiCalculationDisplaysCorrectStatus() {
        // Insert data
        onView(withId(R.id.weightInput)).perform(typeText("65"), closeSoftKeyboard());
        onView(withId(R.id.heightInput)).perform(typeText("170"), closeSoftKeyboard());

        // Act
        onView(withId(R.id.calculateButton)).perform(click());

        // Assert
        onView(withId(R.id.bmiStatus))
                .check(matches(withText("Status: Optimal")));
    }
}
