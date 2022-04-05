package com.training.themusicapp.controller;

import com.training.themusicapp.configuration.ToggleConfig;
import com.training.themusicapp.controller.dto.UserSongDto;
import com.training.themusicapp.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/like")
public class LikeController {

    @Autowired
    LikeService likeService;

    @PostMapping(path = "/song")
    public ResponseEntity<String> likeASong(@RequestBody UserSongDto userSongDto){

        if(!ToggleConfig.isLikeASongEnable){
            return new ResponseEntity("Like a song feature is not yet available", HttpStatus.ACCEPTED);
        }

        if(likeService.likeASong(userSongDto.getUserId(),userSongDto.getSongId())){
            return new ResponseEntity("Song Liked", HttpStatus.OK);
        }
        return new ResponseEntity("Song already liked", HttpStatus.ACCEPTED);
    }

}
