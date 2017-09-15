package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by leland on 14/09/17.
 */

public class NormalTweet extends Tweet {
    public NormalTweet(String message) throws TweetTooLongException {
        super(message);
    }

    public NormalTweet(String message, Date date) throws TweetTooLongException {
        super(message, date);
    }

    @Override
    public Boolean isImportant() {
        return Boolean.FALSE;
    }
}
