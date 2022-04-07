package com.training.themusicapp.controller.dto;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserSongDtoTest {

    @Test
    public void userSongDtoTest(){
        UserSongDto userSongDto = new UserSongDto();
        assertNotNull(userSongDto);
        userSongDto.setUserId("UserId");
        userSongDto.setSongId("SongId");
        assertEquals("UserId",userSongDto.getUserId());
        assertEquals("SongId",userSongDto.getSongId());

    }
}
