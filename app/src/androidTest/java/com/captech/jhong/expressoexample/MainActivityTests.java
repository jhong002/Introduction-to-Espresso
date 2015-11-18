    package com.captech.jhong.expressoexample;

    import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

    @RunWith(AndroidJUnit4.class)
    public class MainActivityTests {

        @Rule
        public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);


        @Test
        public void testToolbarTextChanged() {
            String title = InstrumentationRegistry.getTargetContext().getString(R.string.test_toolbar);
            setUpEditText(title);
            onView(withId(R.id.set_toolbar_title_button)).perform(click());
            onView(allOf(isAssignableFrom(TextView.class), withParent(isAssignableFrom(Toolbar.class))))
                    .check(matches(withText(title)));
        }

        @Test
        public void testTextViewTextChanged(){
            String text = InstrumentationRegistry.getTargetContext().getString(R.string.test_textview);
            setUpEditText(text);
            onView(withId(R.id.set_textview_button)).perform(click());
            onView(withId(R.id.activity_main_textview)).check(matches(withText(text)));

        }

        private static ViewInteraction setUpEditText(String string){
            return onView(withId(R.id.activity_main_edit_text)).perform(typeText(string), closeSoftKeyboard());
        }

    }
