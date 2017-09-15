package ca.ualberta.cs.lonelytwitter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by leland on 14/09/17.
 */


public abstract class Mood {
    private Date date;

    public Mood() {
        this.date = new Date();
    }

    public Mood(Date date) {
        this.date = new Date();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public abstract String format();
}
