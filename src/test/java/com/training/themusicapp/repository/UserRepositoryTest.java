package com.training.themusicapp.repository;

import com.training.themusicapp.repository.entity.UserEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    List<UserEntity> userEntitiesList;

    @Before
    public void setUp(){
        userEntitiesList = new ArrayList<>();
        UserEntity userEntity = new UserEntity();
        userEntity.setId("1");
        userEntity.setUsername("user-name");
        userEntity.setTotalNumberOfLikes(1);
        userEntitiesList.add(userEntity);
        userRepository.saveAll(userEntitiesList);
    }

    @Test
    public void userRepositoryTest(){
        List<UserEntity> userEntity = (List<UserEntity>) userRepository.findAll();
        assertEquals("1",userEntity.get(0).getId());
        assertEquals("user-name",userEntity.get(0).getUsername());
        assertEquals(1,userEntity.get(0).getTotalNumberOfLikes());
    }
}
