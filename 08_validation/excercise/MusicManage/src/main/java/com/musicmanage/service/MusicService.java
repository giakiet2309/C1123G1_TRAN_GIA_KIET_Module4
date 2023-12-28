package com.musicmanage.service;

import com.musicmanage.model.Music;
import com.musicmanage.repository.IMusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MusicService implements IMusicService{
    @Autowired
    IMusicRepository musicRepository;
    @Override
    public List<Music> getAllMusic() {
        return musicRepository.findAll();
    }

    @Override
    public Music getMusicById(int id) {
        return musicRepository.findById(id).get();
    }

    @Override
    public void createMusic(Music music) {
        musicRepository.save(music);
    }

    @Override
    public void updateMusic(Music music) {
        if (getMusicById(music.getId()) != null){
            musicRepository.save(music);
        }
    }

    @Override
    public void deleteMusicById(int id) {
        if (getMusicById(id) != null){
            musicRepository.deleteById(id);
        }
    }
}
