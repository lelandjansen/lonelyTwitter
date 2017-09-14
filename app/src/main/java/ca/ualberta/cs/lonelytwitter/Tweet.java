package ca.ualberta.cs.lonelytwitter;

import java.security.MessageDigest;
import java.util.Date;

/**
 * Created by dezfuli on 9/13/17.
 */

public class Tweet {
    private String message;
    private Date date;

    public Tweet(String message){
        date = new Date();
        this.message = message;
    }

    public Tweet(String message, Date date){
        this.date = date;
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String message) throws TweetTooLongException{
        if (message.length() <= 140){
            this.message = message;
        }
        else{
            throw new TweetTooLongException();
        }
    }
}
