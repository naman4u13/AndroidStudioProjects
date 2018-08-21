package com.example.hp.firstapp;

/**
 * Created by hp on 16-05-2018.
 */

public class word {
    public word(String english, String hindi,int audio) {
        this.english = english;
        this.hindi = hindi;
        this.audio = audio;
    }

    private String english;
    private String hindi;
    private int audio;

    public int getAudio() {
        return audio;
    }


    public String getEnglish() {
        return english;
    }



    public String getHindi() {
        return hindi;
    }


}
