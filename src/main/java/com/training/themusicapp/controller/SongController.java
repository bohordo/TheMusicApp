package com.training.themusicapp.controller;

import com.training.themusicapp.controller.dto.SongDto;
import com.training.themusicapp.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/song")
public class SongController {

    @Autowired
    private SongService songService;

    @GetMapping("/top/{number}")
    public List<SongDto> getTopByNumberSongs(@PathVariable String number)
    {
        if(number.equals("5")){
            return songService.getTopFive();
        }
        if (number.equals("10")){
            return songService.getTopTen();
        }
        if (number.equals("15")){
            return songService.getTopFifteen();
        }
        return songService.getAllSongs();
    }
}
