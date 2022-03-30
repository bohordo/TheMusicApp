package com.training.themusicapp.controller;

import com.training.themusicapp.controller.dto.ArtistDto;
import com.training.themusicapp.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/artist")
public class ArtistController {

    @Autowired
    ArtistService artistService;

    @GetMapping("/get/all")
    public List<ArtistDto> getAll(){
        return artistService.getTopThree();
    }

    @GetMapping("/get/top/three")
    public List<ArtistDto> getTopThree()
    {
        return artistService.getTopThree();

    }

    @GetMapping("/get/top/five")
    public List<ArtistDto> getTopFive(){
        return artistService.getTopFive();
    }
}
