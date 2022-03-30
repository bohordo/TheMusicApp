package com.training.themusicapp.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.themusicapp.repository.entity.SongEntity;
import com.training.themusicapp.service.domain.Song;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class LikeServiceTest {


    LikeService likeService = new LikeService();
    ObjectMapper mapper = new ObjectMapper();

    @Test
    void songPlusOneLike(){
        Song song = new Song();
        song.setNumberOfLikes(0);
        song.setId("id");
        song.setName("song-name");
        song.setArtists("song-artist");
        SongEntity songEntity = mapper.convertValue (song, SongEntity.class);
        song = likeService.songPlusOneLike(songEntity);
        assertEquals (1,song.getNumberOfLikes());
        assertNotEquals (0,song.getNumberOfLikes());
    }
}
