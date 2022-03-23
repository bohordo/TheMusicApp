package com.training.TheMusicApp.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.TheMusicApp.repository.entity.SongEntity;
import com.training.TheMusicApp.service.DataService;
import com.training.TheMusicApp.service.domain.Song;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/data/load")
public class DataController {

    @Autowired
    private DataService dataService;

    @PostMapping("/songs")
    public void loadSongs(@RequestParam("file") File file) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        List<Song> songs = mapper.readValue(file, new TypeReference<List<Song>>(){});

        dataService.saveData(songs);
    }

    @PostMapping("/users")
    public void loadUsers(File usersFile){

    }

    @PostMapping("/artist")
    public void loadArtist(File artistsFile){

    }

}
