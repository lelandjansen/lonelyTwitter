package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by leland on 14/09/17.
 */

public abstract class Tweet implements Tweetable {
    private String message;
    private Date date;
    private ArrayList<Mood> moods = new ArrayList<Mood>();
    private static final int kMaxTweetLength = 140;

    public Tweet(String message) throws TweetTooLongException {
        if (tooLong(message)) throw new TweetTooLongException();
        this.message = message;
        this.date = new Date();
    }

    public Tweet(String message, Date date) throws TweetTooLongException {
        if (tooLong(message)) throw new TweetTooLongException();
        this.message = message;
        this.date = date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) throws TweetTooLongException {
        if (tooLong(message)) throw new TweetTooLongException();
        this.message = message;
    }

    public static Boolean tooLong(String message) {
        return kMaxTweetLength < message.length();
    }

    public ArrayList<Mood> getMoods() {
        return moods;
    }

    public void addMood(Mood mood) {
        this.moods.add(mood);
    }

    public void setMoods(ArrayList<Mood> moods) {
        this.moods = moods;
    }

    public abstract Boolean isImportant();
}
