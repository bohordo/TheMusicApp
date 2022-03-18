package com.training.TheMusicApp.service;

import com.training.TheMusicApp.service.domain.User;
import com.training.TheMusicApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> listUser(){
        return (List<User>) userRepository.findAll();
    }
}
