package com.training.TheMusicApp.service;


import com.training.TheMusicApp.model.Song;
import com.training.TheMusicApp.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {

    @Autowired
    private SongRepository songRepository;

    public List<Song> listSongsIterable(){
        return (List<Song>)songRepository.findAll();
    }

//    public Song save (Song song){
//        return songRepository.save(song);
//    }

    public void save(List<Song> songs){
        songRepository.saveAll(songs);
    }
}
