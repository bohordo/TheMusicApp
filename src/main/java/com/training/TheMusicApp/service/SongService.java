package com.training.TheMusicApp.service;


import com.training.TheMusicApp.controller.dto.SongDto;
import com.training.TheMusicApp.mapper.MappingUtil;
import com.training.TheMusicApp.repository.entity.SongEntity;
import com.training.TheMusicApp.service.domain.Song;
import com.training.TheMusicApp.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class SongService {

    @Autowired
    private MappingUtil mappingUtil;

    @Autowired
    private SongRepository songRepository;

    public List<SongDto> getAllSongs(){
        List<SongEntity> listSong = (List<SongEntity>) songRepository.findAll();
        return mappingUtil.mapAll(listSong, SongDto.class);
    }

    public List<SongDto> getTopFive(){
        List<SongEntity> listSong = songRepository.findTop5ByOrderByNumberOfLikesDesc();
        return mappingUtil.mapAll(listSong, SongDto.class);
    }

    public List<SongDto> getTopTen(){
        List<SongEntity> listSong = songRepository.findTop10ByOrderByNumberOfLikesDesc();
        return mappingUtil.mapAll(listSong, SongDto.class);
    }

    public List<SongDto> getTopFifteen(){
        List<SongEntity> listSong = songRepository.findTop15ByOrderByNumberOfLikesDesc();
        return mappingUtil.mapAll(listSong, SongDto.class);

    }

    public void save(List<SongEntity> songs){
        songRepository.saveAll(songs);
    }
}
