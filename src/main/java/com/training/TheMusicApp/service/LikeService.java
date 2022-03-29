package com.training.TheMusicApp.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.TheMusicApp.repository.ArtistRepository;
import com.training.TheMusicApp.repository.SongRepository;
import com.training.TheMusicApp.repository.UserRepository;
import com.training.TheMusicApp.repository.UserSongRepository;
import com.training.TheMusicApp.repository.entity.ArtistEntity;
import com.training.TheMusicApp.repository.entity.SongEntity;
import com.training.TheMusicApp.repository.entity.UserEntity;
import com.training.TheMusicApp.repository.entity.UserSongEntity;
import com.training.TheMusicApp.service.domain.Artist;
import com.training.TheMusicApp.service.domain.Song;
import com.training.TheMusicApp.service.domain.User;
import com.training.TheMusicApp.service.domain.UserSong;
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

    public void likeASong(String songId, String userId){

        if(!couldYouLikeThatSong(songId,userId)){

            //ObjectMapper mapper = new ObjectMapper();
            Optional<SongEntity> songToLikeEntity = songRepository.findById(songId);

            if(songToLikeEntity.isPresent()){

                Song song = songPlusOneLike(songToLikeEntity.get());


                UserSong userSong = UserSong.builder().id(userId+songId).userId(userId).songId(songId).build();

                Optional<UserEntity> optionalUserEntity = userRepository.findById(userId);
                User user =  mapper.convertValue (optionalUserEntity.get(), User.class);
                user.setTotalNumberOfLikes(user.getTotalNumberOfLikes()+1);

                Optional<ArtistEntity> optionalArtist = artistRepository.findById(song.getArtists());
                Artist artist  = mapper.convertValue (optionalArtist, Artist.class);

                artist.setTotalNumberOfLikes(artist.getTotalNumberOfLikes()+1);

                songRepository.save(mapper.convertValue (song, SongEntity.class));
                userSongRepository.save(mapper.convertValue (userSong, UserSongEntity.class));
                artistRepository.save(mapper.convertValue (artist, ArtistEntity.class));
            }
        }

    }

    public Song songPlusOneLike(SongEntity songToLikeEntity){

        Song song = mapper.convertValue (songToLikeEntity, Song.class);
        song.setNumberOfLikes(song.getNumberOfLikes()+1);
        return song;

    }

    public boolean couldYouLikeThatSong(String songId, String userId){
        return userSongRepository.findById(userId+songId).isPresent();
    }
}
