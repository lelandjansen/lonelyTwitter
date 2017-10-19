package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;

import com.robotium.solo.Solo;

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
        assertTrue(solo.waitForText(text));
    }

    public void testClickTweetList() {
        solo.assertCurrentActivity("some activity",
                LonelyTwitterActivity.class);
        solo.clickOnButton("Clear");
        String text = "testing text";
        EditText editText = (EditText) solo.getView(R.id.body);
        solo.enterText(editText, text);
        solo.clickOnButton("Save");
        solo.waitForText(text);
        solo.clickInList(0);
        solo.assertCurrentActivity("some activity", EditTweetActivity.class);
    }


}