package com.training.themusicapp.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.themusicapp.repository.entity.SongEntity;
import com.training.themusicapp.service.domain.Song;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LikeServiceTest {


    LikeService likeService = new LikeService();
    ObjectMapper mapper = new ObjectMapper();

    @Test
    public void songPlusOneLike(){
        Song song = new Song();
        song.setNumberOfLikes(0);
        song.setId("id");
        song.setName("song-name");
        song.setArtists("song-artist");
        SongEntity songEntity = mapper.convertValue (song, SongEntity.class);
        song = likeService.songPlusOneLike(songEntity);
        assertEquals (song.getNumberOfLikes(),1);
        assertNotEquals (song.getNumberOfLikes(),0);
    }
}
