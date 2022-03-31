package com.training.themusicapp.controller;

import com.training.themusicapp.controller.dto.UserDto;
import com.training.themusicapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController
{

    @Autowired
    private UserService userService;

    @GetMapping("/top/{number}")
    public List<UserDto> getUsersByTop(@PathVariable String number)
    {
        if(number.equals("3")){
            return userService.getTopThree();
        }
        return userService.getAllUsers();
    }
}
