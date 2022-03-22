package com.training.TheMusicApp.service;


import com.training.TheMusicApp.repository.entity.SongEntity;
import com.training.TheMusicApp.service.domain.Song;
import com.training.TheMusicApp.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {

    @Autowired
    private SongRepository songRepository;

    public List<SongEntity> listSongsIterable(){
        return (List<SongEntity>)songRepository.findAll();
    }

//    public Song save (Song song){
//        return songRepository.save(song);
//    }

    public void save(List<SongEntity> songs){
        songRepository.saveAll(songs);
    }
}
