package com.training.themusicapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.themusicapp.controller.dto.UserSongDto;
import com.training.themusicapp.service.LikeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(LikeController.class)
public class LikeControllerTest {

    @MockBean
    LikeService likeService;

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void likeASongShouldResponseOk() throws Exception {

        UserSongDto userSongDto = new UserSongDto();
        userSongDto.setUserId("1cS0TgbR263ey9jn0MwD2");
        userSongDto.setSongId("8cd0f08b-f69d-4ab3-8e3c-16b0b86bbe3a");

        Mockito.when(likeService.likeASong(userSongDto.getSongId(),userSongDto.getUserId())).thenReturn(true);

        mockMvc.perform(post("/like/song")
                .content(mapper.writeValueAsString(userSongDto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void likeASongShouldResponseAccepted() throws Exception {

        UserSongDto userSongDto = new UserSongDto();
        userSongDto.setUserId("1cS0TgbR263ey9jn0MwD2");
        userSongDto.setSongId("8cd0f08b-f69d-4ab3-8e3c-16b0b86bbe3a");

        Mockito.when(likeService.likeASong(userSongDto.getSongId(),userSongDto.getUserId())).thenReturn(false);

        mockMvc.perform(post("/like/song")
                        .content(mapper.writeValueAsString(userSongDto))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isAccepted());
    }
}
