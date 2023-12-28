package com.musicmanage.service;


import com.musicmanage.model.Music;

import java.util.List;

public interface IMusicService {
    List<Music> getAllMusic();
    Music getMusicById(int id);
    void createMusic(Music music);
    void updateMusic(Music music);
    void deleteMusicById(int id);
}
