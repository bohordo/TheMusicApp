package com.training.themusicapp.controller;

import com.training.themusicapp.controller.dto.UserSongDto;
import com.training.themusicapp.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/like")
public class LikeController {

    @Autowired
    LikeService likeService;

    @PostMapping("/song")
    public ResponseEntity<String> likeASong(@RequestBody UserSongDto userSongDto){
        if(likeService.likeASong(userSongDto.getSongId(),userSongDto.getUserId())){
            return new ResponseEntity("Song Liked", HttpStatus.OK);
        }
        return new ResponseEntity("Song already liked", HttpStatus.ACCEPTED);
    }

}
