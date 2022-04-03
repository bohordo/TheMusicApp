package com.training.themusicapp.service.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ArtistTest {

    @Test
    public void shouldValidateArtist(){
        Artist artistTest = new Artist();
        assertNotNull(artistTest);
        artistTest.setId("1");
        artistTest.setName("name");
        artistTest.setTotalNumberOfLikes(1);
        assertEquals("1",artistTest.getId());
        assertEquals("name",artistTest.getName());
        assertEquals(1,artistTest.getTotalNumberOfLikes());
    }
}
