package com.training.themusicapp.controller;

import com.training.themusicapp.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/like")
public class LikeController {

    @Autowired
    LikeService likeService;

    @PostMapping("/song/{songId}/{userId}")
    public ResponseEntity likeASong(@PathVariable String songId, @PathVariable String userId){
        if(likeService.likeASong(songId,userId)){
            return new ResponseEntity("Song Liked", HttpStatus.OK);
        }
        return new ResponseEntity("Song already liked", HttpStatus.ACCEPTED);
    }

}
