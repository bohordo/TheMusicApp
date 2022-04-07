package com.training.themusicapp.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.themusicapp.TheMusicAppApplication;
import com.training.themusicapp.repository.ArtistRepository;
import com.training.themusicapp.repository.SongRepository;
import com.training.themusicapp.repository.UserRepository;
import com.training.themusicapp.repository.UserSongRepository;
import com.training.themusicapp.repository.entity.ArtistEntity;
import com.training.themusicapp.repository.entity.SongEntity;
import com.training.themusicapp.repository.entity.UserEntity;
import com.training.themusicapp.repository.entity.UserSongEntity;
import com.training.themusicapp.service.domain.Song;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TheMusicAppApplication.class})
class LikeServiceTest {

    @MockBean
    private UserSongRepository userSongRepository;
    @MockBean
    private ArtistRepository artistRepository;
    @MockBean
    private SongRepository songRepository;
    @MockBean
    private UserRepository userRepository;

    @Autowired
    LikeService likeService = new LikeService();

    ObjectMapper mapper = new ObjectMapper();
    UserSongEntity userSongEntity;
    UserEntity userEntity;
    ArtistEntity artistEntity;
    Song song;

    @Test
    void shouldBeTrueWhenLikeASong(){

        userSongEntity = new UserSongEntity();
        userSongEntity.setSongId("SongId");
        userSongEntity.setUserId("UserId");

        userEntity = new UserEntity();
        userEntity.setId("UserId");
        userEntity.setUsername("user");
        Mockito.when(userRepository.findById(userEntity.getId())).thenReturn(Optional.of(userEntity));

        artistEntity = new ArtistEntity();
        artistEntity.setId("ArtistId");
        artistEntity.setName("artist");
        Mockito.when(artistRepository.findById(artistEntity.getId())).thenReturn(Optional.of(artistEntity));

        song = new Song();
        song.setNumberOfLikes(0);
        song.setId("SongId");
        song.setName("song-name");
        song.setArtists("artist");
        Mockito.when(artistRepository.findByName(song.getArtists())).thenReturn(artistEntity);
        SongEntity songEntity = mapper.convertValue (song, SongEntity.class);
        Mockito.when(songRepository.findById(song.getId())).thenReturn(Optional.of(songEntity));

        assertTrue(likeService.likeASong(userSongEntity.getUserId(),userSongEntity.getSongId()));
    }

    @Test
    void shouldBeFalseWhenLikeASong(){
        assertFalse(likeService.likeASong("123","456"));
    }

    @Test
    void shouldBeFalseWhenLikeASongBecauseTheSongIsAlreadyLiked(){
        userSongEntity = new UserSongEntity();
        userSongEntity.setSongId("SongId");
        userSongEntity.setUserId("UserId");
        Mockito.when(userSongRepository.findById("UserIdSongId")).thenReturn(Optional.of(userSongEntity));
        assertFalse(likeService.likeASong("UserId","SongId"));
    }

    @Test
    void songPlusOneLike(){
        userSongEntity = new UserSongEntity();
        userSongEntity.setSongId("SongId");
        userSongEntity.setUserId("UserId");

        song = new Song();
        song.setNumberOfLikes(0);
        song.setId("SongId");
        song.setName("song-name");
        song.setArtists("artist-song");

        SongEntity songEntity = mapper.convertValue (song, SongEntity.class);
        assertEquals (1,likeService.songPlusOneLike(songEntity).getNumberOfLikes());
        assertNotEquals (0,likeService.songPlusOneLike(songEntity).getNumberOfLikes());
    }

    @Test
    void shouldBeTrueWhenValidatingIfASongCouldBeLiked(){
        userSongEntity = new UserSongEntity();
        userSongEntity.setSongId("SongId");
        userSongEntity.setUserId("UserId");
        userSongEntity.setId(userSongEntity.getSongId()+userSongEntity.getUserId());
        Mockito.when(userSongRepository.findById(userSongEntity.getId())).thenReturn(Optional.of(userSongEntity));
        assertTrue(likeService.couldYouLikeThatSong(userSongEntity.getSongId(),userSongEntity.getUserId()));
    }

    @Test
    void shouldBeFalseWhenValidatingIfASongCouldBeLiked(){
        assertFalse(likeService.couldYouLikeThatSong("789","456"));
    }
}
