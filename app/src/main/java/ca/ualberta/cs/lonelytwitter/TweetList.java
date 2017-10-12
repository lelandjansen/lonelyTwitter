package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class TweetList {
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public TweetList() {}

    public void add(Tweet tweet) {
        tweets.add(tweet);
    }

    public void delete(Tweet tweet) {
        tweets.remove(tweet);
    }

    public boolean hasTweet(Tweet tweet) {
        return tweets.contains(tweet);
    }

    public Tweet getTweet(int index) {
        return tweets.get(index);
    }

    public int getCount() {
        return tweets.size();
    }

    public ArrayList getTweets() {
        Collections.sort(this.tweets, new Comparator<Tweet>() {
            public int compare(Tweet tweet, Tweet t1) {
                if (tweet.getDate().before(t1.getDate())) return -1;
                if (t1.getDate().before(tweet.getDate())) return 1;
                return 0;
            }
        });
        return tweets;
    }
}
