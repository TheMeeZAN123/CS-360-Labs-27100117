package com.example.lonelytwitter;

import java.util.Date;

public class ImportantTweet extends Tweet{
    ImportantTweet(String message) {
        super(message);

    }
    ImportantTweet(String message, Date date){
        super(message,date);
    }

    @Override
    public Boolean isImportant() {
        return Boolean.TRUE;
    }

}
