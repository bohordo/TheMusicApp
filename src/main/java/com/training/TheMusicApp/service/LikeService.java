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

    public void likeASong(String songId, String userId){

        if(!couldYouLikeThatSong(songId,userId)){

            ObjectMapper mapper = new ObjectMapper();
            Optional songToLike = songRepository.findById(songId);

            if(songToLike.isPresent()){
                SongEntity song =  mapper.convertValue (songToLike.get(), SongEntity.class);
                song.setNumberOfLikes(song.getNumberOfLikes()+1);

                UserSongEntity userSongEntity = new UserSongEntity();
                userSongEntity.setId(userId+songId);
                userSongEntity.setUserId(userId);
                userSongEntity.setSongId(songId);

                Optional<UserEntity> optionalUserEntity = userRepository.findById(userId);
                UserEntity userEntity = optionalUserEntity.get();
                userEntity.setTotalNumberOfLikes(userEntity.getTotalNumberOfLikes()+1);

                Optional<ArtistEntity> OptionalArtistEntity = artistRepository.findById(song.getArtists());
                ArtistEntity artistEntity = OptionalArtistEntity.get();
                artistEntity.setTotalNumberOfLikes(artistEntity.getTotalNumberOfLikes()+1);

                songRepository.save(song);
                userSongRepository.save(userSongEntity);


                artistRepository.save(artistEntity);
            }
        }

    }

    public boolean couldYouLikeThatSong(String songId, String userId){
        return userSongRepository.findById(userId+songId).isPresent();
    }
}
