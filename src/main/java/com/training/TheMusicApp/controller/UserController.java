package com.training.TheMusicApp.controller;

import com.training.TheMusicApp.controller.dto.SongDto;
import com.training.TheMusicApp.controller.dto.UserDto;
import com.training.TheMusicApp.mapper.MappingUtil;
import com.training.TheMusicApp.repository.entity.UserEntity;
import com.training.TheMusicApp.service.domain.Song;
import com.training.TheMusicApp.service.domain.User;
import com.training.TheMusicApp.service.SongService;
import com.training.TheMusicApp.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController
{

    @Autowired
    private UserService userService;

    @GetMapping("/get/all")
    public List<UserDto> getUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/get/top/three")
    public List<UserDto> getTopThree(){
        return userService.getTopThree();
    }

}
