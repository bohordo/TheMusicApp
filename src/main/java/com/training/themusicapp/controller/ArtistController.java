package com.training.themusicapp.controller;

import com.training.themusicapp.controller.dto.ArtistDto;
import com.training.themusicapp.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/artist")
public class ArtistController {

    @Autowired
    ArtistService artistService;

    @GetMapping("/top/{number}")
    public List<ArtistDto> getTopByNumber(@PathVariable String number)
    {
        if (number.equals("3")){
            return artistService.getTopThree();
        }
        if (number.equals("5")){
            return artistService.getTopFive();
        }
            return artistService.getAllArtist();
    }
}
