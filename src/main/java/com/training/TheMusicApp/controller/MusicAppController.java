package com.training.TheMusicApp.controller;

import com.training.TheMusicApp.service.domain.Song;
import com.training.TheMusicApp.service.domain.User;
import com.training.TheMusicApp.service.SongService;
import com.training.TheMusicApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MusicAppController
{

    @Autowired
    private SongService songService;

    @Autowired
    private UserService userService;

    @GetMapping ("/getSongs")
    public List<Song> getSongs(){
        return songService.listSongsIterable();
    }

    @GetMapping("/getArtist")
    public List<String> getArtist(){

        return null;
    }

    @GetMapping("/getUsers")
    public List<User> getUsers(){
        return userService.listUser();
    }

}
