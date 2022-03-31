package com.training.themusicapp.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.themusicapp.mapper.MappingUtil;
import com.training.themusicapp.service.DataService;
import com.training.themusicapp.service.domain.Artist;
import com.training.themusicapp.service.domain.Song;
import com.training.themusicapp.service.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/data")
public class DataController {

    @Autowired
    private DataService dataService;

    @PostMapping("load/songs")
    public void loadSongs(@RequestParam ("file") MultipartFile file) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Song> songs = mapper.readValue(file.getInputStream(), new TypeReference<List<Song>>(){});
        dataService.saveSongsData(songs);
    }

    @PostMapping("/load/users")
    public void loadUsers(@RequestParam ("file") MultipartFile file) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<User> users = mapper.readValue(file.getInputStream(), new TypeReference<List<User>>(){});
        dataService.saveUsersData(users);
    }

    @PostMapping("/load/artist")
    public void loadArtist(@RequestParam ("file") MultipartFile file) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Artist> artist = mapper.readValue(file.getInputStream(), new TypeReference<List<Artist>>(){});
        dataService.saveArtistData(artist);
    }

}
