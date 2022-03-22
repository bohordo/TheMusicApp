package com.training.TheMusicApp.controller;

import com.training.TheMusicApp.controller.dto.UserDto;
import com.training.TheMusicApp.repository.entity.UserEntity;
import com.training.TheMusicApp.service.domain.Song;
import com.training.TheMusicApp.service.domain.User;
import com.training.TheMusicApp.service.SongService;
import com.training.TheMusicApp.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController
{

    private ModelMapper mapper;

    @Autowired
    private UserService userService;

    @GetMapping("/getUsers")
    public List<UserDto> getUsers(){
        List<UserEntity> userList = userService.listUser();
        return (List<UserDto>) mapper.map(userList,UserDto.class);
    }

    @PostMapping("/createUser")
    public void createUser(){

    }

}
