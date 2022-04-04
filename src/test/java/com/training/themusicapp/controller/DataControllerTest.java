package com.training.themusicapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.themusicapp.service.DataService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebAppConfiguration
@RunWith(SpringRunner.class)
@WebMvcTest(DataController.class)
public class DataControllerTest {

    @MockBean
    DataService dataService;

    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp(){

    }

    @Test
    public void shouldSaidThatSaveSongsDataIsAlreadyLoaded() throws Exception {
        MockMultipartFile jsonFile =
                new MockMultipartFile(
                        "file",
                        "spotify-top100-2018.json",
                        "application/json",
                        "[{\"id\":\"songId\",\"name\": \"IDK\",\"artists\": \"Drake\",\"numberOfLikes\": 1}]"
                                .getBytes());
        mockMvc
                = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        mockMvc.perform(multipart("/data/load/songs").file(jsonFile))
                .andExpect(status().isAccepted());
    }

    @Test
    public void shouldSaidThatSaveUsersDataTestIsAlreadyLoaded() throws Exception{
        MockMultipartFile jsonFile =
                new MockMultipartFile(
                        "file",
                        "spotify-top100-2018.json",
                        "application/json",
                        "[{\"id\":\"userId\",\"username\": \"Lorenzo\",\"numberOfLikes\": 1}]"
                                .getBytes());
        mockMvc
                = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        mockMvc.perform(multipart("/data/load/users").file(jsonFile))
                .andExpect(status().isAccepted());
    }

    @Test
    public void shouldSaidThatSaveArtistDataTestIsAlreadyLoaded() throws Exception{
        MockMultipartFile jsonFile =
                new MockMultipartFile(
                        "file",
                        "spotify-top100-2018.json",
                        "application/json",
                        "[{\"name\": \"IDK\",\"numberOfLikes\": 1}]"
                                .getBytes());
        mockMvc
                = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        mockMvc.perform(multipart("/data/load/artist").file(jsonFile))
                .andExpect(status().isAccepted());
    }
}
