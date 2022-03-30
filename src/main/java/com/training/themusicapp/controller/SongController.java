package com.training.themusicapp.controller;

import com.training.themusicapp.controller.dto.SongDto;
import com.training.themusicapp.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/song")
public class SongController {

    @Autowired
    private SongService songService;

    @GetMapping("/get/all")
    public List<SongDto> getAllSongs(){
        return songService.getAllSongs();
    }

    @GetMapping("/get/top/five")
    public List<SongDto> getTopFive(){
        return songService.getTopFive();
    }

    @GetMapping("/get/top/ten")
    public List<SongDto> getTopTen(){
        return songService.getTopTen();
    }

    @GetMapping("/get/top/fifteen")
    public List<SongDto> getTopFifteen(){
        return songService.getTopFifteen();
    }
}
