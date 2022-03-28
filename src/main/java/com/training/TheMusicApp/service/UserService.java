package com.training.TheMusicApp.service;

import com.training.TheMusicApp.controller.dto.SongDto;
import com.training.TheMusicApp.controller.dto.UserDto;
import com.training.TheMusicApp.mapper.MappingUtil;
import com.training.TheMusicApp.repository.entity.SongEntity;
import com.training.TheMusicApp.repository.entity.UserEntity;
import com.training.TheMusicApp.service.domain.User;
import com.training.TheMusicApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    @Autowired
    private MappingUtil mappingUtil;



    @Autowired
    private UserRepository userRepository;

    public List<UserDto> getAllUsers(){
        List<UserEntity> listUsers = (List<UserEntity>) userRepository.findAll();
        return mappingUtil.mapAll(listUsers, UserDto.class);
    }

    public List<UserDto> getTopThree(){
        List<UserEntity> listUsers = userRepository.findTop3ByOrderByTotalNumberOfLikesDesc();
        return mappingUtil.mapAll(listUsers, UserDto.class);
    }
}
