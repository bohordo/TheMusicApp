package com.training.themusicapp.service.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SongTest {

    @Test
    public void shouldValidateSong(){
        Song song = new Song();
        assertNotNull(song);
        song.setId("1");
        song.setName("name");
        song.setArtists("artist");
        song.setNumberOfLikes(1);
        assertEquals("1",song.getId());
        assertEquals("name",song.getName());
        assertEquals("artist",song.getArtists());
        assertEquals(1,song.getNumberOfLikes());
    }
}
