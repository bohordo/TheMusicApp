package com.training.TheMusicApp.service;

import com.training.TheMusicApp.controller.dto.ArtistDto;
import com.training.TheMusicApp.mapper.MappingUtil;
import com.training.TheMusicApp.repository.ArtistRepository;
import com.training.TheMusicApp.repository.entity.ArtistEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistService {

    @Autowired
    private MappingUtil mappingUtil;

    @Autowired
    ArtistRepository artistRepository;

    public List<ArtistDto> getAllArtist(){
        List<ArtistEntity> listSong = (List<ArtistEntity>) artistRepository.findAll();
        return mappingUtil.mapAll(listSong, ArtistDto.class);
    }

    public List<ArtistDto> getTopThree (){
        List<ArtistEntity> listSong = artistRepository.findTop3ByOrderByTotalNumberOfLikesDesc();
        return mappingUtil.mapAll(listSong, ArtistDto.class);
    }

    public List<ArtistDto> getTopFive (){
        List<ArtistEntity> listSong = artistRepository.findTop5ByOrderByTotalNumberOfLikesDesc();
        return mappingUtil.mapAll(listSong, ArtistDto.class);
    }

}
