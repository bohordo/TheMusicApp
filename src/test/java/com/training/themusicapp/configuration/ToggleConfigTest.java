package com.training.themusicapp.configuration;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ToggleConfigTest {


    @Test
    public void toggleConfigTest(){
        assertTrue(ToggleConfig.IS_LIKE_A_SONG_ENABLED);
    }
}
