package com.training.themusicapp.service;

import com.training.themusicapp.controller.dto.UserDto;
import com.training.themusicapp.mapper.MappingUtil;
import com.training.themusicapp.repository.entity.UserEntity;
import com.training.themusicapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    @Autowired
    private MappingUtil mappingUtil;

    @Autowired
    private UserRepository userRepository;

    public List<UserDto> getUsers(String number){
        if (number.equals("3")){
            return getTopThree();
        }
        return getAllUsers();
    }

    public List<UserDto> getAllUsers(){
        List<UserEntity> listUsers = (List<UserEntity>) userRepository.findAll();
        return mappingUtil.mapAll(listUsers, UserDto.class);
    }

    public List<UserDto> getTopThree(){
        List<UserEntity> listUsers = userRepository.findTop3ByOrderByTotalNumberOfLikesDesc();
        return mappingUtil.mapAll(listUsers, UserDto.class);
    }
}
