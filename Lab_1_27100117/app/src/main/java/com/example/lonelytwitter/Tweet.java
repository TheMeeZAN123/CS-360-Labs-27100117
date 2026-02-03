package com.example.lonelytwitter;

import java.util.Date;

public abstract class Tweet implements Tweetable {
    Date date;
    String message;
    Tweet(String message)
    {
        date = new Date();
        this.message = message;
    }
    Tweet(String message, Date date)
    {
        this.date = date;
        this.message = message;
    }
    public abstract Boolean isImportant();
    public String getMessage(){
        return this.message;
    }
    public Date getDate(){
        return this.date;
    }


}
