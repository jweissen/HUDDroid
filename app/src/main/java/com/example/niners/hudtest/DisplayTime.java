package com.example.niners.hudtest;

/**
 * Created by Jon Weissenburger on 5/11/16.
 */
public class DisplayTime {

    int millis;

    private DisplayTime(int millis) {
        this.millis = millis;
    }

    public static DisplayTime fromSeconds(int seconds) {
        return new DisplayTime(seconds * 1000);
    }

    public static DisplayTime fromMillis(int millis) {
        return new DisplayTime(millis);
    }

    public static DisplayTime fromMinutes(int minutes) {
        return new DisplayTime(minutes * 60 * 1000);
    }
}
