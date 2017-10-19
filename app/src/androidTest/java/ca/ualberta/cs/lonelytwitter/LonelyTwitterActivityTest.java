package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;

import com.robotium.solo.Solo;

import junit.framework.TestCase;

public class LonelyTwitterActivityTest
        extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {
    private Solo solo;

    public LonelyTwitterActivityTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    public void setUp() {
        solo = new Solo(getInstrumentation(), getActivity());
    }

    public void tearDown() {
        solo.finishOpenedActivities();
    }

    public void testStart() throws Exception {
        Activity activity = getActivity();

    }

    public void testTweet() {
        solo.assertCurrentActivity("some activity",
                LonelyTwitterActivity.class);
        String text = "http://bit.ly/IqT6zt";
        EditText editText = (EditText) solo.getView(R.id.body);
        solo.enterText(editText, text);
        solo.clickOnButton("Save");
//        solo.enterText(editText, "");
        assertTrue(solo.waitForText(text));
    }

    public void testClickTweetList() {

    }


}