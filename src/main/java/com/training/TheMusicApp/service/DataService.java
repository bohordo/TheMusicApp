package com.training.TheMusicApp.service;

import com.training.TheMusicApp.mapper.MappingUtil;
import com.training.TheMusicApp.repository.ArtistRepository;
import com.training.TheMusicApp.repository.SongRepository;
import com.training.TheMusicApp.repository.UserRepository;
import com.training.TheMusicApp.repository.entity.ArtistEntity;
import com.training.TheMusicApp.repository.entity.SongEntity;
import com.training.TheMusicApp.repository.entity.UserEntity;
import com.training.TheMusicApp.service.domain.Artist;
import com.training.TheMusicApp.service.domain.Song;
import com.training.TheMusicApp.service.domain.User;
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
        List <SongEntity> songEntities = mappingUtil.mapAll(songs, SongEntity.class);
        songRepository.saveAll(songEntities);
    }

    public void saveUsersData(List <User> users){
        List <UserEntity> userEntities = mappingUtil.mapAll(users, UserEntity.class);
        userRepository.saveAll(userEntities);
    }

    public void saveArtistData(List <Artist> artists){
        List <ArtistEntity> artistsEntities = mappingUtil.mapAll(artists, ArtistEntity.class);
        artistRepository.saveAll(artistsEntities);
    }

}
