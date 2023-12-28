package com.musicmanage.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Music{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String musicName;
    private String artist;
    private String musicType;

    public Music() {
    }

    public Music(int id, String musicName, String artist, String musicType) {
        this.id = id;
        this.musicName = musicName;
        this.artist = artist;
        this.musicType = musicType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getMusicType() {
        return musicType;
    }

    public void setMusicType(String musicType) {
        this.musicType = musicType;
    }
}
