/*
 * Class name: SadMood
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

import java.util.Date;

/**
 *
 */
public class SadMood extends Mood {
    /**
     * Construct SadMood
     */
    public SadMood() {
        super();
    }

    /**
     * Set mood date
     * @param date Date
     */
    public SadMood(Date date) {
        super(date);
    }

    /**
     * String representation of SadMood
     * @return ":("
     */
    public String format() {
        return ":(";
    }
}
