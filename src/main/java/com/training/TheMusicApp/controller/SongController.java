package com.training.TheMusicApp.controller;

import com.training.TheMusicApp.controller.dto.SongDto;
import com.training.TheMusicApp.service.SongService;
import com.training.TheMusicApp.service.domain.Song;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SongController {

    ModelMapper mapper;

    @Autowired
    private SongService songService;

    @GetMapping("/getSongs")
    public List<SongDto> getSongs(){
        List<Song> listSong = songService.listSongsIterable();
        return (List<SongDto>) mapper.map(listSong,SongDto.class);
    }
}
