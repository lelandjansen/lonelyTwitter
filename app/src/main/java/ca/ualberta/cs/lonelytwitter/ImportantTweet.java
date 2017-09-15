package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by leland on 14/09/17.
 */

public class ImportantTweet extends Tweet {
    public ImportantTweet(String messaage) throws TweetTooLongException {
        super(messaage);
    }

    public ImportantTweet(String message, Date date) throws TweetTooLongException {
        super(message, date);
    }

    @Override
    public Boolean isImportant() {
        return Boolean.TRUE;
    }

}
