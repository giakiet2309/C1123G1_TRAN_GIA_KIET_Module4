package com.musicmanage.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


public class MusicDto implements Validator {
    private int id;
    private String musicName;
    private String artist;
    private String musicType;

    public MusicDto() {
    }

    public MusicDto(int id, String musicName, String artist, String musicType) {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        MusicDto musicDto = (MusicDto) target;
        if (!musicDto.getMusicName().matches("^[a-zA-Z0-9 ]{1,800}$")){
            errors.rejectValue("musicName",null,"Tên bài hát không hợp lệ");
        }
        if (!musicDto.getArtist().matches("^[a-zA-Z0-9 ]{1,300}$")){
            errors.rejectValue("artist",null,"Tên người thể hiện không hợp lệ");
        }
        if (!musicDto.getMusicType().matches("^[a-zA-Z0-9, ]{1,1000}$")){
            errors.rejectValue("musicType",null,"Thể loại bài hát không hợp lệ");
        }
    }
}
