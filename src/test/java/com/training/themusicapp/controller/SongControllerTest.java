package com.training.themusicapp.controller;

import com.training.themusicapp.controller.dto.SongDto;
import com.training.themusicapp.service.SongService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(SongController.class)
public class SongControllerTest {

    @MockBean
    SongService songService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getSongs () throws Exception {

        List<SongDto> listSongDto = new ArrayList<>();
        SongDto songDto = new SongDto();
        listSongDto.add(songDto);

        Mockito.when(songService.getSongs("1")).thenReturn(listSongDto);

        mockMvc.perform(get("/song/top/1"))
                .andExpect(status().isOk());
    }
}
