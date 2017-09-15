package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by leland on 14/09/17.
 */

public class HappyMood extends Mood {
    public HappyMood() {
        super();
    }

    public HappyMood(Date date) {
        super(date);
    }

    public String format() {
        return ":)";
    }
}
