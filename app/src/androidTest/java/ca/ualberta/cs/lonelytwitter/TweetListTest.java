package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.util.ArrayList;
import java.util.Date;

public class TweetListTest extends ActivityInstrumentationTestCase2 {
    public TweetListTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    public void testAddTweet() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("tweet");
        tweets.add(tweet);
        assertTrue(tweets.hasTweet(tweet));
    }

    public void testDeleteTweet() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("tweet");
        tweets.add(tweet);
        tweets.delete(tweet);
        assertFalse(tweets.hasTweet(tweet));
    }

    public void testHasTweet() {
        TweetList tweets = new TweetList();
        Tweet tweet1 = new NormalTweet("tweet1");
        Tweet tweet2 = new NormalTweet("tweet2");
        tweets.add(tweet1);
        assertTrue(tweets.hasTweet(tweet1));
        assertFalse(tweets.hasTweet(tweet2));
    }

    public void testGetTweet() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("tweet");
        tweets.add(tweet);
        Tweet returnedTweet = tweets.getTweet(0);
        assertEquals(returnedTweet.getMessage(), tweet.getMessage());
    }

    public void testGetCount() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("tweet");
        assertEquals(0, tweets.getCount());
        tweets.add(tweet);
        assertEquals(1, tweets.getCount());
        tweets.add(new NormalTweet("tweet2"));
        assertEquals(2, tweets.getCount());
        tweets.delete(tweet);
        assertEquals(1, tweets.getCount());
    }

    public void testGetTweets() {
        TweetList tweets = new TweetList();
        Tweet first = new NormalTweet("first");
        first.setDate(new Date(0));
        Tweet second = new NormalTweet("second");
        second.setDate(new Date(1));
        Tweet third = new NormalTweet("third");
        third.setDate(new Date(2));

        tweets.add(third);
        tweets.add(second);
        tweets.add(first);

        ArrayList<Tweet> expected = new ArrayList<Tweet>();
        expected.add(first);
        expected.add(second);
        expected.add(third);

        ArrayList<Tweet> result = tweets.getTweets();
        assertEquals(expected.size(), result.size());

        for (int i = 0; i < expected.size(); ++i) {
            assertEquals(expected.get(i).getMessage(),
                         result.get(i).getMessage());
        }
    }
}
