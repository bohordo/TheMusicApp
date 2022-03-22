package com.training.TheMusicApp.controller;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class ArtistController {

    @GetMapping("/getArtist")
    public List<String> getArtist(){
        return null;
    }
}
