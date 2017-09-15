package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by leland on 14/09/17.
 */

public class SadMood extends Mood {
    public SadMood() {
        super();
    }

    public SadMood(Date date) {
        super(date);
    }

    public String format() {
        return ":(";
    }
}
