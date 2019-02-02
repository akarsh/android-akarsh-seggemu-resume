package com.sakarsh.akarshseggemuresume;


import android.support.test.espresso.DataInteraction;
import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }

    @Test
    public void mainActivityTest() {
        DataInteraction linearLayout = onData(anything())
                .inAdapterView(allOf(withId(R.id.listView),
                        childAtPosition(
                                withClassName(is("android.widget.RelativeLayout")),
                                0)))
                .atPosition(0);
        linearLayout.perform(click());

        DataInteraction linearLayout2 = onData(anything())
                .inAdapterView(allOf(withId(R.id.listView),
                        childAtPosition(
                                withClassName(is("android.widget.RelativeLayout")),
                                0)))
                .atPosition(0);
        linearLayout2.perform(click());

        ViewInteraction appCompatImageButton = onView(
                allOf(withContentDescription("\u200E\u200F\u200E\u200E\u200E\u200E\u200E\u200F\u200E\u200F\u200F\u200F\u200E\u200E\u200E\u200E\u200E\u200F\u200E\u200E\u200F\u200E\u200E\u200E\u200E\u200F\u200F\u200F\u200F\u200F\u200E\u200F\u200F\u200E\u200F\u200F\u200E\u200E\u200E\u200E\u200F\u200F\u200F\u200F\u200F\u200F\u200F\u200E\u200F\u200F\u200F\u200F\u200F\u200E\u200F\u200E\u200E\u200F\u200F\u200E\u200F\u200E\u200E\u200E\u200E\u200E\u200F\u200F\u200F\u200E\u200F\u200E\u200E\u200E\u200E\u200E\u200F\u200F\u200E\u200F\u200F\u200E\u200E\u200F\u200E\u200F\u200E\u200F\u200F\u200F\u200F\u200F\u200E\u200ENavigate up\u200E\u200F\u200E\u200E\u200F\u200E"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton.perform(click());

        DataInteraction linearLayout3 = onData(anything())
                .inAdapterView(allOf(withId(R.id.listView),
                        childAtPosition(
                                withClassName(is("android.widget.RelativeLayout")),
                                0)))
                .atPosition(1);
        linearLayout3.perform(click());

        ViewInteraction appCompatImageButton2 = onView(
                allOf(withContentDescription("\u200E\u200F\u200E\u200E\u200E\u200E\u200E\u200F\u200E\u200F\u200F\u200F\u200E\u200E\u200E\u200E\u200E\u200F\u200E\u200E\u200F\u200E\u200E\u200E\u200E\u200F\u200F\u200F\u200F\u200F\u200E\u200F\u200F\u200E\u200F\u200F\u200E\u200E\u200E\u200E\u200F\u200F\u200F\u200F\u200F\u200F\u200F\u200E\u200F\u200F\u200F\u200F\u200F\u200E\u200F\u200E\u200E\u200F\u200F\u200E\u200F\u200E\u200E\u200E\u200E\u200E\u200F\u200F\u200F\u200E\u200F\u200E\u200E\u200E\u200E\u200E\u200F\u200F\u200E\u200F\u200F\u200E\u200E\u200F\u200E\u200F\u200E\u200F\u200F\u200F\u200F\u200F\u200E\u200ENavigate up\u200E\u200F\u200E\u200E\u200F\u200E"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton2.perform(click());

        DataInteraction linearLayout4 = onData(anything())
                .inAdapterView(allOf(withId(R.id.listView),
                        childAtPosition(
                                withClassName(is("android.widget.RelativeLayout")),
                                0)))
                .atPosition(2);
        linearLayout4.perform(click());

        ViewInteraction appCompatImageButton3 = onView(
                allOf(withContentDescription("\u200E\u200F\u200E\u200E\u200E\u200E\u200E\u200F\u200E\u200F\u200F\u200F\u200E\u200E\u200E\u200E\u200E\u200F\u200E\u200E\u200F\u200E\u200E\u200E\u200E\u200F\u200F\u200F\u200F\u200F\u200E\u200F\u200F\u200E\u200F\u200F\u200E\u200E\u200E\u200E\u200F\u200F\u200F\u200F\u200F\u200F\u200F\u200E\u200F\u200F\u200F\u200F\u200F\u200E\u200F\u200E\u200E\u200F\u200F\u200E\u200F\u200E\u200E\u200E\u200E\u200E\u200F\u200F\u200F\u200E\u200F\u200E\u200E\u200E\u200E\u200E\u200F\u200F\u200E\u200F\u200F\u200E\u200E\u200F\u200E\u200F\u200E\u200F\u200F\u200F\u200F\u200F\u200E\u200ENavigate up\u200E\u200F\u200E\u200E\u200F\u200E"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton3.perform(click());

        DataInteraction linearLayout5 = onData(anything())
                .inAdapterView(allOf(withId(R.id.listView),
                        childAtPosition(
                                withClassName(is("android.widget.RelativeLayout")),
                                0)))
                .atPosition(3);
        linearLayout5.perform(click());

        ViewInteraction appCompatImageButton4 = onView(
                allOf(withContentDescription("\u200E\u200F\u200E\u200E\u200E\u200E\u200E\u200F\u200E\u200F\u200F\u200F\u200E\u200E\u200E\u200E\u200E\u200F\u200E\u200E\u200F\u200E\u200E\u200E\u200E\u200F\u200F\u200F\u200F\u200F\u200E\u200F\u200F\u200E\u200F\u200F\u200E\u200E\u200E\u200E\u200F\u200F\u200F\u200F\u200F\u200F\u200F\u200E\u200F\u200F\u200F\u200F\u200F\u200E\u200F\u200E\u200E\u200F\u200F\u200E\u200F\u200E\u200E\u200E\u200E\u200E\u200F\u200F\u200F\u200E\u200F\u200E\u200E\u200E\u200E\u200E\u200F\u200F\u200E\u200F\u200F\u200E\u200E\u200F\u200E\u200F\u200E\u200F\u200F\u200F\u200F\u200F\u200E\u200ENavigate up\u200E\u200F\u200E\u200E\u200F\u200E"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton4.perform(click());

        DataInteraction linearLayout6 = onData(anything())
                .inAdapterView(allOf(withId(R.id.listView),
                        childAtPosition(
                                withClassName(is("android.widget.RelativeLayout")),
                                0)))
                .atPosition(4);
        linearLayout6.perform(click());

        ViewInteraction appCompatImageButton5 = onView(
                allOf(withContentDescription("\u200E\u200F\u200E\u200E\u200E\u200E\u200E\u200F\u200E\u200F\u200F\u200F\u200E\u200E\u200E\u200E\u200E\u200F\u200E\u200E\u200F\u200E\u200E\u200E\u200E\u200F\u200F\u200F\u200F\u200F\u200E\u200F\u200F\u200E\u200F\u200F\u200E\u200E\u200E\u200E\u200F\u200F\u200F\u200F\u200F\u200F\u200F\u200E\u200F\u200F\u200F\u200F\u200F\u200E\u200F\u200E\u200E\u200F\u200F\u200E\u200F\u200E\u200E\u200E\u200E\u200E\u200F\u200F\u200F\u200E\u200F\u200E\u200E\u200E\u200E\u200E\u200F\u200F\u200E\u200F\u200F\u200E\u200E\u200F\u200E\u200F\u200E\u200F\u200F\u200F\u200F\u200F\u200E\u200ENavigate up\u200E\u200F\u200E\u200E\u200F\u200E"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton5.perform(click());

        DataInteraction linearLayout7 = onData(anything())
                .inAdapterView(allOf(withId(R.id.listView),
                        childAtPosition(
                                withClassName(is("android.widget.RelativeLayout")),
                                0)))
                .atPosition(5);
        linearLayout7.perform(click());

        ViewInteraction appCompatImageButton6 = onView(
                allOf(withContentDescription("\u200E\u200F\u200E\u200E\u200E\u200E\u200E\u200F\u200E\u200F\u200F\u200F\u200E\u200E\u200E\u200E\u200E\u200F\u200E\u200E\u200F\u200E\u200E\u200E\u200E\u200F\u200F\u200F\u200F\u200F\u200E\u200F\u200F\u200E\u200F\u200F\u200E\u200E\u200E\u200E\u200F\u200F\u200F\u200F\u200F\u200F\u200F\u200E\u200F\u200F\u200F\u200F\u200F\u200E\u200F\u200E\u200E\u200F\u200F\u200E\u200F\u200E\u200E\u200E\u200E\u200E\u200F\u200F\u200F\u200E\u200F\u200E\u200E\u200E\u200E\u200E\u200F\u200F\u200E\u200F\u200F\u200E\u200E\u200F\u200E\u200F\u200E\u200F\u200F\u200F\u200F\u200F\u200E\u200ENavigate up\u200E\u200F\u200E\u200E\u200F\u200E"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton6.perform(click());

        DataInteraction linearLayout8 = onData(anything())
                .inAdapterView(allOf(withId(R.id.listView),
                        childAtPosition(
                                withClassName(is("android.widget.RelativeLayout")),
                                0)))
                .atPosition(6);
        linearLayout8.perform(click());

        ViewInteraction appCompatImageButton7 = onView(
                allOf(withContentDescription("\u200E\u200F\u200E\u200E\u200E\u200E\u200E\u200F\u200E\u200F\u200F\u200F\u200E\u200E\u200E\u200E\u200E\u200F\u200E\u200E\u200F\u200E\u200E\u200E\u200E\u200F\u200F\u200F\u200F\u200F\u200E\u200F\u200F\u200E\u200F\u200F\u200E\u200E\u200E\u200E\u200F\u200F\u200F\u200F\u200F\u200F\u200F\u200E\u200F\u200F\u200F\u200F\u200F\u200E\u200F\u200E\u200E\u200F\u200F\u200E\u200F\u200E\u200E\u200E\u200E\u200E\u200F\u200F\u200F\u200E\u200F\u200E\u200E\u200E\u200E\u200E\u200F\u200F\u200E\u200F\u200F\u200E\u200E\u200F\u200E\u200F\u200E\u200F\u200F\u200F\u200F\u200F\u200E\u200ENavigate up\u200E\u200F\u200E\u200E\u200F\u200E"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton7.perform(click());

        DataInteraction linearLayout9 = onData(anything())
                .inAdapterView(allOf(withId(R.id.listView),
                        childAtPosition(
                                withClassName(is("android.widget.RelativeLayout")),
                                0)))
                .atPosition(7);
        linearLayout9.perform(click());

        ViewInteraction appCompatImageButton8 = onView(
                allOf(withContentDescription("\u200E\u200F\u200E\u200E\u200E\u200E\u200E\u200F\u200E\u200F\u200F\u200F\u200E\u200E\u200E\u200E\u200E\u200F\u200E\u200E\u200F\u200E\u200E\u200E\u200E\u200F\u200F\u200F\u200F\u200F\u200E\u200F\u200F\u200E\u200F\u200F\u200E\u200E\u200E\u200E\u200F\u200F\u200F\u200F\u200F\u200F\u200F\u200E\u200F\u200F\u200F\u200F\u200F\u200E\u200F\u200E\u200E\u200F\u200F\u200E\u200F\u200E\u200E\u200E\u200E\u200E\u200F\u200F\u200F\u200E\u200F\u200E\u200E\u200E\u200E\u200E\u200F\u200F\u200E\u200F\u200F\u200E\u200E\u200F\u200E\u200F\u200E\u200F\u200F\u200F\u200F\u200F\u200E\u200ENavigate up\u200E\u200F\u200E\u200E\u200F\u200E"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton8.perform(click());

        DataInteraction linearLayout10 = onData(anything())
                .inAdapterView(allOf(withId(R.id.listView),
                        childAtPosition(
                                withClassName(is("android.widget.RelativeLayout")),
                                0)))
                .atPosition(8);
        linearLayout10.perform(click());

        ViewInteraction appCompatImageButton9 = onView(
                allOf(withContentDescription("\u200E\u200F\u200E\u200E\u200E\u200E\u200E\u200F\u200E\u200F\u200F\u200F\u200E\u200E\u200E\u200E\u200E\u200F\u200E\u200E\u200F\u200E\u200E\u200E\u200E\u200F\u200F\u200F\u200F\u200F\u200E\u200F\u200F\u200E\u200F\u200F\u200E\u200E\u200E\u200E\u200F\u200F\u200F\u200F\u200F\u200F\u200F\u200E\u200F\u200F\u200F\u200F\u200F\u200E\u200F\u200E\u200E\u200F\u200F\u200E\u200F\u200E\u200E\u200E\u200E\u200E\u200F\u200F\u200F\u200E\u200F\u200E\u200E\u200E\u200E\u200E\u200F\u200F\u200E\u200F\u200F\u200E\u200E\u200F\u200E\u200F\u200E\u200F\u200F\u200F\u200F\u200F\u200E\u200ENavigate up\u200E\u200F\u200E\u200E\u200F\u200E"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton9.perform(click());

        DataInteraction linearLayout11 = onData(anything())
                .inAdapterView(allOf(withId(R.id.listView),
                        childAtPosition(
                                withClassName(is("android.widget.RelativeLayout")),
                                0)))
                .atPosition(9);
        linearLayout11.perform(click());

        ViewInteraction appCompatImageButton10 = onView(
                allOf(withContentDescription("\u200E\u200F\u200E\u200E\u200E\u200E\u200E\u200F\u200E\u200F\u200F\u200F\u200E\u200E\u200E\u200E\u200E\u200F\u200E\u200E\u200F\u200E\u200E\u200E\u200E\u200F\u200F\u200F\u200F\u200F\u200E\u200F\u200F\u200E\u200F\u200F\u200E\u200E\u200E\u200E\u200F\u200F\u200F\u200F\u200F\u200F\u200F\u200E\u200F\u200F\u200F\u200F\u200F\u200E\u200F\u200E\u200E\u200F\u200F\u200E\u200F\u200E\u200E\u200E\u200E\u200E\u200F\u200F\u200F\u200E\u200F\u200E\u200E\u200E\u200E\u200E\u200F\u200F\u200E\u200F\u200F\u200E\u200E\u200F\u200E\u200F\u200E\u200F\u200F\u200F\u200F\u200F\u200E\u200ENavigate up\u200E\u200F\u200E\u200E\u200F\u200E"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton10.perform(click());

        DataInteraction linearLayout12 = onData(anything())
                .inAdapterView(allOf(withId(R.id.listView),
                        childAtPosition(
                                withClassName(is("android.widget.RelativeLayout")),
                                0)))
                .atPosition(10);
        linearLayout12.perform(click());

        ViewInteraction appCompatImageButton11 = onView(
                allOf(withContentDescription("\u200E\u200F\u200E\u200E\u200E\u200E\u200E\u200F\u200E\u200F\u200F\u200F\u200E\u200E\u200E\u200E\u200E\u200F\u200E\u200E\u200F\u200E\u200E\u200E\u200E\u200F\u200F\u200F\u200F\u200F\u200E\u200F\u200F\u200E\u200F\u200F\u200E\u200E\u200E\u200E\u200F\u200F\u200F\u200F\u200F\u200F\u200F\u200E\u200F\u200F\u200F\u200F\u200F\u200E\u200F\u200E\u200E\u200F\u200F\u200E\u200F\u200E\u200E\u200E\u200E\u200E\u200F\u200F\u200F\u200E\u200F\u200E\u200E\u200E\u200E\u200E\u200F\u200F\u200E\u200F\u200F\u200E\u200E\u200F\u200E\u200F\u200E\u200F\u200F\u200F\u200F\u200F\u200E\u200ENavigate up\u200E\u200F\u200E\u200E\u200F\u200E"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton11.perform(click());

        DataInteraction linearLayout13 = onData(anything())
                .inAdapterView(allOf(withId(R.id.listView),
                        childAtPosition(
                                withClassName(is("android.widget.RelativeLayout")),
                                0)))
                .atPosition(11);
        linearLayout13.perform(click());

        ViewInteraction appCompatImageButton12 = onView(
                allOf(withContentDescription("\u200E\u200F\u200E\u200E\u200E\u200E\u200E\u200F\u200E\u200F\u200F\u200F\u200E\u200E\u200E\u200E\u200E\u200F\u200E\u200E\u200F\u200E\u200E\u200E\u200E\u200F\u200F\u200F\u200F\u200F\u200E\u200F\u200F\u200E\u200F\u200F\u200E\u200E\u200E\u200E\u200F\u200F\u200F\u200F\u200F\u200F\u200F\u200E\u200F\u200F\u200F\u200F\u200F\u200E\u200F\u200E\u200E\u200F\u200F\u200E\u200F\u200E\u200E\u200E\u200E\u200E\u200F\u200F\u200F\u200E\u200F\u200E\u200E\u200E\u200E\u200E\u200F\u200F\u200E\u200F\u200F\u200E\u200E\u200F\u200E\u200F\u200E\u200F\u200F\u200F\u200F\u200F\u200E\u200ENavigate up\u200E\u200F\u200E\u200E\u200F\u200E"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton12.perform(click());

        DataInteraction linearLayout14 = onData(anything())
                .inAdapterView(allOf(withId(R.id.listView),
                        childAtPosition(
                                withClassName(is("android.widget.RelativeLayout")),
                                0)))
                .atPosition(12);
        linearLayout14.perform(click());

        ViewInteraction appCompatImageButton13 = onView(
                allOf(withContentDescription("\u200E\u200F\u200E\u200E\u200E\u200E\u200E\u200F\u200E\u200F\u200F\u200F\u200E\u200E\u200E\u200E\u200E\u200F\u200E\u200E\u200F\u200E\u200E\u200E\u200E\u200F\u200F\u200F\u200F\u200F\u200E\u200F\u200F\u200E\u200F\u200F\u200E\u200E\u200E\u200E\u200F\u200F\u200F\u200F\u200F\u200F\u200F\u200E\u200F\u200F\u200F\u200F\u200F\u200E\u200F\u200E\u200E\u200F\u200F\u200E\u200F\u200E\u200E\u200E\u200E\u200E\u200F\u200F\u200F\u200E\u200F\u200E\u200E\u200E\u200E\u200E\u200F\u200F\u200E\u200F\u200F\u200E\u200E\u200F\u200E\u200F\u200E\u200F\u200F\u200F\u200F\u200F\u200E\u200ENavigate up\u200E\u200F\u200E\u200E\u200F\u200E"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton13.perform(click());

        ViewInteraction appCompatImageButton14 = onView(
                allOf(withContentDescription("\u200E\u200F\u200E\u200E\u200E\u200E\u200E\u200F\u200E\u200F\u200F\u200F\u200E\u200E\u200E\u200E\u200E\u200F\u200E\u200E\u200F\u200E\u200E\u200E\u200E\u200F\u200F\u200F\u200F\u200F\u200E\u200F\u200F\u200E\u200F\u200F\u200E\u200E\u200E\u200E\u200F\u200F\u200F\u200F\u200F\u200F\u200F\u200E\u200F\u200F\u200F\u200F\u200F\u200E\u200F\u200E\u200E\u200F\u200F\u200E\u200F\u200E\u200E\u200E\u200E\u200E\u200F\u200F\u200F\u200E\u200F\u200E\u200E\u200E\u200E\u200E\u200F\u200F\u200E\u200F\u200F\u200E\u200E\u200F\u200E\u200F\u200E\u200F\u200F\u200F\u200F\u200F\u200E\u200ENavigate up\u200E\u200F\u200E\u200E\u200F\u200E"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton14.perform(click());

        DataInteraction linearLayout15 = onData(anything())
                .inAdapterView(allOf(withId(R.id.listView),
                        childAtPosition(
                                withClassName(is("android.widget.RelativeLayout")),
                                0)))
                .atPosition(1);
        linearLayout15.perform(click());

        DataInteraction linearLayout16 = onData(anything())
                .inAdapterView(allOf(withId(R.id.listView),
                        childAtPosition(
                                withClassName(is("android.widget.RelativeLayout")),
                                0)))
                .atPosition(0);
        linearLayout16.perform(click());

        ViewInteraction appCompatImageButton15 = onView(
                allOf(withContentDescription("Nach oben"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton15.perform(click());

        DataInteraction linearLayout17 = onData(anything())
                .inAdapterView(allOf(withId(R.id.listView),
                        childAtPosition(
                                withClassName(is("android.widget.RelativeLayout")),
                                0)))
                .atPosition(1);
        linearLayout17.perform(click());

        ViewInteraction appCompatImageButton16 = onView(
                allOf(withContentDescription("Nach oben"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton16.perform(click());

        DataInteraction linearLayout18 = onData(anything())
                .inAdapterView(allOf(withId(R.id.listView),
                        childAtPosition(
                                withClassName(is("android.widget.RelativeLayout")),
                                0)))
                .atPosition(2);
        linearLayout18.perform(click());

        ViewInteraction appCompatImageButton17 = onView(
                allOf(withContentDescription("Nach oben"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton17.perform(click());

        DataInteraction linearLayout19 = onData(anything())
                .inAdapterView(allOf(withId(R.id.listView),
                        childAtPosition(
                                withClassName(is("android.widget.RelativeLayout")),
                                0)))
                .atPosition(3);
        linearLayout19.perform(click());

        ViewInteraction appCompatImageButton18 = onView(
                allOf(withContentDescription("Nach oben"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton18.perform(click());

        DataInteraction linearLayout20 = onData(anything())
                .inAdapterView(allOf(withId(R.id.listView),
                        childAtPosition(
                                withClassName(is("android.widget.RelativeLayout")),
                                0)))
                .atPosition(4);
        linearLayout20.perform(click());

        ViewInteraction appCompatImageButton19 = onView(
                allOf(withContentDescription("Nach oben"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton19.perform(click());

        DataInteraction linearLayout21 = onData(anything())
                .inAdapterView(allOf(withId(R.id.listView),
                        childAtPosition(
                                withClassName(is("android.widget.RelativeLayout")),
                                0)))
                .atPosition(5);
        linearLayout21.perform(click());

        ViewInteraction appCompatImageButton20 = onView(
                allOf(withContentDescription("Nach oben"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton20.perform(click());

        DataInteraction linearLayout22 = onData(anything())
                .inAdapterView(allOf(withId(R.id.listView),
                        childAtPosition(
                                withClassName(is("android.widget.RelativeLayout")),
                                0)))
                .atPosition(6);
        linearLayout22.perform(click());

        ViewInteraction appCompatImageButton21 = onView(
                allOf(withContentDescription("Nach oben"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton21.perform(click());

        DataInteraction linearLayout23 = onData(anything())
                .inAdapterView(allOf(withId(R.id.listView),
                        childAtPosition(
                                withClassName(is("android.widget.RelativeLayout")),
                                0)))
                .atPosition(7);
        linearLayout23.perform(click());

        ViewInteraction appCompatImageButton22 = onView(
                allOf(withContentDescription("Nach oben"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton22.perform(click());

        DataInteraction linearLayout24 = onData(anything())
                .inAdapterView(allOf(withId(R.id.listView),
                        childAtPosition(
                                withClassName(is("android.widget.RelativeLayout")),
                                0)))
                .atPosition(8);
        linearLayout24.perform(click());

        ViewInteraction appCompatImageButton23 = onView(
                allOf(withContentDescription("Nach oben"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton23.perform(click());

        DataInteraction linearLayout25 = onData(anything())
                .inAdapterView(allOf(withId(R.id.listView),
                        childAtPosition(
                                withClassName(is("android.widget.RelativeLayout")),
                                0)))
                .atPosition(9);
        linearLayout25.perform(click());

        ViewInteraction appCompatImageButton24 = onView(
                allOf(withContentDescription("Nach oben"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton24.perform(click());

        DataInteraction linearLayout26 = onData(anything())
                .inAdapterView(allOf(withId(R.id.listView),
                        childAtPosition(
                                withClassName(is("android.widget.RelativeLayout")),
                                0)))
                .atPosition(11);
        linearLayout26.perform(click());

        ViewInteraction appCompatImageButton25 = onView(
                allOf(withContentDescription("Nach oben"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton25.perform(click());

        DataInteraction linearLayout27 = onData(anything())
                .inAdapterView(allOf(withId(R.id.listView),
                        childAtPosition(
                                withClassName(is("android.widget.RelativeLayout")),
                                0)))
                .atPosition(10);
        linearLayout27.perform(click());

        ViewInteraction appCompatImageButton26 = onView(
                allOf(withContentDescription("Nach oben"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton26.perform(click());

        DataInteraction linearLayout28 = onData(anything())
                .inAdapterView(allOf(withId(R.id.listView),
                        childAtPosition(
                                withClassName(is("android.widget.RelativeLayout")),
                                0)))
                .atPosition(12);
        linearLayout28.perform(click());

        ViewInteraction appCompatImageButton27 = onView(
                allOf(withContentDescription("Nach oben"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton27.perform(click());

        ViewInteraction appCompatImageButton28 = onView(
                allOf(withContentDescription("Nach oben"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton28.perform(click());
    }
}
