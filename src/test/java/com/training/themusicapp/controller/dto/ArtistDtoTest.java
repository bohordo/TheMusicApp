package com.training.themusicapp.controller.dto;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ArtistDtoTest {

    @Test
    public void shouldValidateArtistDto(){
        ArtistDto artistDto = new ArtistDto();
        assertNotNull(artistDto);
        artistDto.setName("ArtistDto");
        assertEquals("ArtistDto",artistDto.getName());
        artistDto.setTotalNumberOfLikes(1);
        assertEquals(1,artistDto.getTotalNumberOfLikes());
    }
}
