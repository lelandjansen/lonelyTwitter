/*
 * Class name: Tweet
 *
 * Version: 1.0.0
 *
 * Date: September 28, 2017
 *
 * Copyright 2017 Leland Jansen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

/**
 * Represents a Tweet.
 *
 * @author Leland Jansen
 * @version 1.0.0
 * @see Tweetable
 * @see NormalTweet
 * @see ImportantTweet
 * @since 1.0.0
 */
public abstract class Tweet implements Tweetable {
    private String message;
    private Date date;
    private ArrayList<Mood> moods = new ArrayList<Mood>();
    private static final int kMaxTweetLength = 140;

    /**
     * Constructs a Tweet object (date = now)
     * @param message 140-character Tweet message
     * @throws TweetTooLongException
     */
    public Tweet(String message) throws TweetTooLongException {
        if (tooLong(message)) throw new TweetTooLongException();
        this.message = message;
        this.date = new Date();
    }

    /**
     * Constructs a Tweet object
     * @param message 140-character Tweet message
     * @param date Tweet date
     * @throws TweetTooLongException
     */
    public Tweet(String message, Date date) throws TweetTooLongException {
        if (tooLong(message)) throw new TweetTooLongException();
        this.message = message;
        this.date = date;
    }

    /**
     * Set Tweet date
     * @param date Date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Get Tweet's date
     * @return Tweet's date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Get Tweet's message
     * @return Tweet's message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Set Tweet's message
     * @param message Tweet's message
     * @throws TweetTooLongException
     */
    public void setMessage(String message) throws TweetTooLongException {
        if (tooLong(message)) throw new TweetTooLongException();
        this.message = message;
    }

    /**
     * Is message too long to be contained in a tweet?
     * @param message Tweet message
     * @return True if message is longer than 140 characters
     */
    public static Boolean tooLong(String message) {
        return kMaxTweetLength < message.length();
    }

    /**
     * Get Tweet's moods
     * @return Tweet's moods
     */
    public ArrayList<Mood> getMoods() {
        return moods;
    }

    /**
     * Add mood to Tweet
     * @param mood Tweet mood
     */
    public void addMood(Mood mood) {
        this.moods.add(mood);
    }

    /**
     * Set Tweet mood
     * @param moods Tweet mood
     */
    public void setMoods(ArrayList<Mood> moods) {
        this.moods = moods;
    }

    /**
     * Is Tweet important?
     * @return True if the Tweet is important
     */
    public abstract Boolean isImportant();

    /**
     * Represent Tweet as a string
     * @return String representation of Tweet
     */
    @Override
    public String toString() {
        return date.toString() + " | " + message;
    }
}
