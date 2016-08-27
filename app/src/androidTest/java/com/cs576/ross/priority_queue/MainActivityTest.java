package com.cs576.ross.priority_queue;

import android.support.test.espresso.NoMatchingViewException;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withTagKey;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Ross on 8/27/16.
 */
public class MainActivityTest {

    @Rule
    public final ActivityRule<MainActivity> main = new ActivityRule<>(MainActivity.class);

    @Test
    public void checkForAddQueue(){
        try{
            //check if button is displayed
            onView(withText("Add To Queue")).check(matches(isDisplayed()));
            //click on the button
            onView(withId(R.id.add)).perform(click());
            //check for corresponding elements once button is clicked
            onView(withId(R.id.editText)).check(matches(isDisplayed()));
            onView(withId(R.id.priorityInput)).check(matches(isDisplayed()));
            onView(withId(R.id.insert)).check(matches(isDisplayed()));
            onView(withId(R.id.done)).check(matches(isDisplayed()));

            onView(withId(R.id.editText)).perform(typeText("test"));
            onView(withId(R.id.priorityInput)).perform(typeText(String.valueOf(1)));
            onView(withId(R.id.insert)).perform(click());
            onView(withId(R.id.done)).perform(click());
        }catch(NoMatchingViewException e){
            System.out.println(e);
        }
    }
    @Test
    public void checkForShowQueue(){

        try {
            //check if button is displayed
            onView(withText("Show Queue")).check(matches(isDisplayed()));
            //onView(withText("Show Queue")).perform(click()).check(matches(isDisplayed()));
            //click on the button
            onView(withId(R.id.showQueue)).perform(click());
            //check if the android alert box is displayed
            onView(withText("Priority Queue: ")).check(matches(isDisplayed()));
        } catch (NoMatchingViewException e) {
            //view not displayed logic
            System.out.println(e);
        }
    }
    @Test
    public void checkForMaximum(){
        try{

            onView(withId(R.id.add)).perform(click());
            onView(withId(R.id.editText)).perform(typeText("test"));
            onView(withId(R.id.priorityInput)).perform(typeText(String.valueOf(1)));
            onView(withId(R.id.insert)).perform(click());
            onView(withId(R.id.done)).perform(click());

            //check if the button is displayed
            onView(withText("Maximum")).check(matches(isDisplayed()));
            //click on the button
            onView(withId(R.id.max)).perform(click());
            //check if the android alert box is displayed
            onView(withText("Max:")).check(matches(isDisplayed()));
        }catch(NoMatchingViewException e){
            System.out.println(e);
        }
    }
    @Test
    public void checkForExtractMax(){
        try{
            onView(withId(R.id.add)).perform(click());
            onView(withId(R.id.editText)).perform(typeText("test"));
            onView(withId(R.id.priorityInput)).perform(typeText(String.valueOf(1)));
            onView(withId(R.id.insert)).perform(click());
            onView(withId(R.id.done)).perform(click());

            //check if the button is displayed
            onView(withText("Extract Max")).check(matches(isDisplayed()));
            //click on the button
            onView(withId(R.id.extractMax)).perform(click());
            //check if the android alert box is displayed
            onView(withText("Extract max:")).check(matches(isDisplayed()));
        }catch(NoMatchingViewException e){
            System.out.println(e);
        }
    }

}
