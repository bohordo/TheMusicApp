package com.training.themusicapp.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.themusicapp.repository.ArtistRepository;
import com.training.themusicapp.repository.SongRepository;
import com.training.themusicapp.repository.UserRepository;
import com.training.themusicapp.repository.UserSongRepository;
import com.training.themusicapp.repository.entity.ArtistEntity;
import com.training.themusicapp.repository.entity.SongEntity;
import com.training.themusicapp.repository.entity.UserEntity;
import com.training.themusicapp.repository.entity.UserSongEntity;
import com.training.themusicapp.service.domain.Artist;
import com.training.themusicapp.service.domain.Song;
import com.training.themusicapp.service.domain.User;
import com.training.themusicapp.service.domain.UserSong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LikeService {

    @Autowired
    SongRepository songRepository;

    @Autowired
    UserSongRepository userSongRepository;

    @Autowired
    ArtistRepository artistRepository;

    @Autowired
    UserRepository userRepository;

    ObjectMapper mapper = new ObjectMapper();

    public boolean likeASong(String userId, String songId){

        if(!couldYouLikeThatSong(userId, songId)){

            Optional<SongEntity> songToLikeEntity = songRepository.findById(songId);

            if(songToLikeEntity.isPresent()){

                Song song = songPlusOneLike(songToLikeEntity.get());

                UserSong userSong = UserSong.builder().id(userId+songId).userId(userId).songId(songId).build();

                Optional<UserEntity> optionalUserEntity = userRepository.findById(userId);
                User user =  mapper.convertValue (optionalUserEntity.orElse(null), User.class);
                user.setTotalNumberOfLikes(user.getTotalNumberOfLikes()+1);

                ArtistEntity optionalArtist = artistRepository.findByName(song.getArtists());

                Artist artist  = mapper.convertValue (optionalArtist, Artist.class);

                artist.setTotalNumberOfLikes(artist.getTotalNumberOfLikes()+1);

                songRepository.save(mapper.convertValue (song, SongEntity.class));
                userSongRepository.save(mapper.convertValue (userSong, UserSongEntity.class));
                artistRepository.save(mapper.convertValue (artist, ArtistEntity.class));
                userRepository.save(mapper.convertValue (user, UserEntity.class));

                return true;
            }
        }

        return false;
    }

    public Song songPlusOneLike(SongEntity songToLikeEntity){

        Song song = mapper.convertValue (songToLikeEntity, Song.class);
        song.setNumberOfLikes(song.getNumberOfLikes()+1);
        return song;

    }

    public boolean couldYouLikeThatSong(String userId, String songId){
        return userSongRepository.findById(userId+songId).isPresent();
    }
}
