package com.training.TheMusicApp.service;

import com.training.TheMusicApp.mapper.MappingUtil;
import com.training.TheMusicApp.repository.SongRepository;
import com.training.TheMusicApp.repository.entity.SongEntity;
import com.training.TheMusicApp.service.domain.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService {

    @Autowired
    private SongRepository songRepository;

    private MappingUtil mappingUtil;

    public void saveData(List <Song> songs){
        List <SongEntity> songEntities = mappingUtil.mapAll(songs, SongEntity.class);
        songRepository.saveAll(songEntities);
    }

}
