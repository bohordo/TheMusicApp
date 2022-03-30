package com.training.themusicapp.controller;

import com.training.themusicapp.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void likeASong(@PathVariable String songId,@PathVariable String userId){
        likeService.likeASong(songId,userId);
    }

}
