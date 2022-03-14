package com.training.TheMusicApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MusicAppController
{
    @GetMapping ("/getSongs")
    public List<String> getSongs(){

        return null;
    }

    @GetMapping("/getArtist")
    public List<String> getArtist(){

        return null;
    }

}
