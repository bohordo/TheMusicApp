package com.training.themusicapp.service.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserSongTest {

    @Test
    public void shouldValidateUserSong(){
        UserSong userSong = UserSong.builder().build();
        assertNotNull(userSong);
        userSong.setId("11");
        userSong.setSongId("1");
        userSong.setUserId("1");
        assertEquals("11",userSong.getId());
        assertEquals("1",userSong.getSongId());
        assertEquals("1",userSong.getUserId());
    }
}
