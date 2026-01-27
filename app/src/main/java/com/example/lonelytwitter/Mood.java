package com.example.lonelytwitter;

import java.util.Date;

public abstract class Mood {
    private Date date;
    Mood(){
        this.date = new Date();
    }
    Mood(Date date){
        this.date = date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }
    abstract public String getMood();

}
