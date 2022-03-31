package com.training.themusicapp.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.themusicapp.mapper.MappingUtil;
import com.training.themusicapp.repository.ArtistRepository;
import com.training.themusicapp.repository.SongRepository;
import com.training.themusicapp.repository.UserRepository;
import com.training.themusicapp.repository.entity.ArtistEntity;
import com.training.themusicapp.repository.entity.SongEntity;
import com.training.themusicapp.repository.entity.UserEntity;
import com.training.themusicapp.service.domain.Artist;
import com.training.themusicapp.service.domain.Song;
import com.training.themusicapp.service.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService {

    @Autowired
    private SongRepository songRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private MappingUtil mappingUtil;

    public void saveSongsData(List <Song> songs){
        ObjectMapper mapper = new ObjectMapper();
        List <SongEntity> songEntities = mappingUtil.mapAll(songs, SongEntity.class);
        songRepository.saveAll(songEntities);
    }

    public void saveUsersData(List <User> users){
        List <UserEntity> userEntities = mappingUtil.mapAll(users, UserEntity.class);
        userRepository.saveAll(userEntities);
    }

    public void saveArtistData(List <Artist> artists) throws JsonProcessingException {
        List <ArtistEntity> artistsEntities = mappingUtil.mapAll(artists, ArtistEntity.class);
        artistRepository.saveAll(artistsEntities);
    }

}
