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
@RequestMapping(path = "/song")
public class SongController {

    @Autowired
    private SongService songService;

    @GetMapping(path = "/top/{number}")
    public List<SongDto> getTopByNumberSongs(@PathVariable String number)
    {
        return songService.getSongs(number);
    }
}
