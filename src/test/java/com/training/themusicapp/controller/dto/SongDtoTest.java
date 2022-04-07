package com.training.themusicapp.controller.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SongDtoTest {

    @Test
    public void shouldValidateSongDto(){
        SongDto songDto = new SongDto();
        assertNotNull(songDto);
        songDto.setId("id");
        assertEquals("id", songDto.getId());
        songDto.setName("song");
        assertEquals("song",songDto.getName());
        songDto.setArtists("artist");
        assertEquals("artist",songDto.getArtists());
        songDto.setNumberOfLikes(1);
        assertEquals(1,songDto.getNumberOfLikes());
    }

}
