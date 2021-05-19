package cat.itb.apptestespresso;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.not;


@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    String USER_TO_BE_TYPED ="Jota";
    String PASS_TO_BE_TYPED = "cancereza";
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void elementsOnActivityMainAreDisplayed() {
        onView(withId(R.id.main_activity_text)).check(matches(isDisplayed()));
        onView(withId(R.id.boton_next)).check(matches(isDisplayed()));
    }

    @Test
    public void elementsOnActivityMainHaveTheCorrectText() {
        onView(withId(R.id.main_activity_text)).check(matches(withText(R.string.main_activity_title)));
        onView(withId(R.id.boton_next)).check(matches(withText(R.string.next)));
    }

    @Test
    public void nextButtonIsClickableAndChangeTextToBackWhenClicked() {
        onView(withId(R.id.boton_next)).check(matches(isClickable()));
        onView(withId(R.id.boton_next)).perform(click()).check(matches(withText("Back")));
    }

    @Test
    public void insertsAValueOnTheUsernameEditTextAndClosesKeyboard() {
        onView(withId(R.id.user_login)).perform(typeText(USER_TO_BE_TYPED),closeSoftKeyboard());
    }

    @Test
    public void insertAValueOnThePasswordEditTextAndClosesKeyboard() {
        onView(withId(R.id.pass_login)).perform(typeText(PASS_TO_BE_TYPED)).perform(closeSoftKeyboard());
    }

    @Test
    public void whenNextButtonIsClickedItChangesTheTextToLogged() {
        onView(withId(R.id.boton_next)).perform(click()).check(matches(withText("Logged")));
    }
}
