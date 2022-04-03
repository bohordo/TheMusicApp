package com.training.themusicapp.service;


import com.training.themusicapp.controller.dto.SongDto;
import com.training.themusicapp.mapper.MappingUtil;
import com.training.themusicapp.repository.entity.SongEntity;
import com.training.themusicapp.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {

    @Autowired
    private MappingUtil mappingUtil;

    @Autowired
    private SongRepository songRepository;

    public List<SongDto> getSongs(String number){

        if(number.equals("5")){
            return getTopFive();
        }
        if(number.equals("10")){
            return getTopTen();
        }
        if(number.equals("15")){
            return getTopFifteen();
        }
        return getAllSongs();
    }

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
}
