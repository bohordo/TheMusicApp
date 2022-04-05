package com.training.themusicapp.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.themusicapp.service.DataService;
import com.training.themusicapp.service.domain.Artist;
import com.training.themusicapp.service.domain.Song;
import com.training.themusicapp.service.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "/data")
public class DataController {

    @Autowired
    private DataService dataService;

    @PostMapping(path = "load/songs")
    public ResponseEntity <String> loadSongs(@RequestParam ("file") MultipartFile file) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Song> songs = mapper.readValue(file.getInputStream(), new TypeReference<List<Song>>(){});
        if(dataService.saveSongsData(songs)){
            return new ResponseEntity("Songs loaded", HttpStatus.OK);
        }
        return new ResponseEntity("Songs already loaded", HttpStatus.ACCEPTED);
    }

    @PostMapping(path = "/load/users")
    public ResponseEntity <String> loadUsers(@RequestParam ("file") MultipartFile file) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<User> users = mapper.readValue(file.getInputStream(), new TypeReference<List<User>>(){});
        if(dataService.saveUsersData(users)){
            return new ResponseEntity("Users loaded", HttpStatus.OK);
        }
        return new ResponseEntity("Users already loaded", HttpStatus.ACCEPTED);
    }

    @PostMapping(path = "/load/artist")
    public ResponseEntity <String> loadArtist(@RequestParam ("file") MultipartFile file) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Artist> artist = mapper.readValue(file.getInputStream(), new TypeReference<List<Artist>>(){});
        if(dataService.saveArtistData(artist)){
            return new ResponseEntity("Artist loaded", HttpStatus.OK);
        }
        return new ResponseEntity("Artist already loaded", HttpStatus.ACCEPTED);
    }
}
