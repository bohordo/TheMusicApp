package com.training.themusicapp.service;

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
import java.util.stream.StreamSupport;

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

    public boolean saveSongsData(List <Song> songs){
        List <SongEntity> songEntities = mappingUtil.mapAll(songs, SongEntity.class);
        if(songs.size()==StreamSupport.stream(songRepository.findAll().spliterator(), false).count()){
            return false;
        }
        songRepository.saveAll(songEntities);
        return true;
    }

    public boolean saveUsersData(List <User> users){
        List <UserEntity> userEntities = mappingUtil.mapAll(users, UserEntity.class);
        if(users.size()==StreamSupport.stream(userRepository.findAll().spliterator(), false).count()){
            return false;
        }
        userRepository.saveAll(userEntities);
        return true;
    }

    public boolean saveArtistData(List <Artist> artists){
        List <ArtistEntity> artistsEntities = mappingUtil.mapAll(artists, ArtistEntity.class);
        if(artists.size()==StreamSupport.stream(artistRepository.findAll().spliterator(), false).count()){
            return false;
        }
        artistRepository.saveAll(artistsEntities);
        return true;
    }
}
