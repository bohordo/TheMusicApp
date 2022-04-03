package com.training.themusicapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.themusicapp.controller.dto.ArtistDto;
import com.training.themusicapp.service.ArtistService;
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
@WebMvcTest(ArtistController.class)
public class ArtistControllerTest {

    @MockBean
    ArtistService artistService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldGetTopByNumber() throws Exception {
        List<ArtistDto> listArtistDto = new ArrayList<>();
        ArtistDto artistDto = new ArtistDto();
        listArtistDto.add(artistDto);

        Mockito.when(artistService.getArtist("1")).thenReturn(listArtistDto);

        mockMvc.perform(get("/artist/top/1"))
                .andExpect(status().isOk());
    }
}
