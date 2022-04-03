package com.training.themusicapp.service;

import com.training.themusicapp.TheMusicAppApplication;
import com.training.themusicapp.repository.UserRepository;
import com.training.themusicapp.repository.entity.UserEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TheMusicAppApplication.class})
public class UserServiceTest {

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    List<UserEntity> userEntities;
    List<UserEntity> userEntitiesTopThree;

    @Before
    public void setUp(){
        userEntities = new ArrayList<>();
        userEntitiesTopThree = new ArrayList<>();

        UserEntity userEntityOne = new UserEntity();
        userEntityOne.setId("1");
        userEntityOne.setUsername("one");
        userEntityOne.setTotalNumberOfLikes(1);
        userEntities.add(userEntityOne);
        userEntitiesTopThree.add(userEntityOne);

        UserEntity userEntityTwo = new UserEntity();
        userEntityTwo.setId("2");
        userEntityTwo.setUsername("two");
        userEntityTwo.setTotalNumberOfLikes(2);
        userEntities.add(userEntityTwo);
        userEntitiesTopThree.add(userEntityTwo);

        UserEntity userEntityThree = new UserEntity();
        userEntityThree.setId("3");
        userEntityThree.setUsername("three");
        userEntityThree.setTotalNumberOfLikes(3);
        userEntities.add(userEntityThree);
        userEntitiesTopThree.add(userEntityThree);

        UserEntity userEntityFour = new UserEntity();
        userEntityFour.setId("4");
        userEntityFour.setUsername("four");
        userEntityFour.setTotalNumberOfLikes(4);
        userEntities.add(userEntityFour);

        Iterable<UserEntity> artistEntityIterable = userEntities;
        Mockito.when(userRepository.findAll()).thenReturn(artistEntityIterable);
        Mockito.when(userRepository.findTop3ByOrderByTotalNumberOfLikesDesc()).thenReturn(userEntitiesTopThree);
    }

    @Test
    public void shouldGetTopThreeUser(){
        assertEquals(3,userService.getUsers("3").size());
    }

    @Test
    public void shouldGetTopAllUser(){
        assertEquals(4,userService.getUsers("1").size());
    }

    @Test
    public void shouldFindTopThree(){
        assertEquals(3,userService.getTopThree().size());
    }

    @Test
    public void shouldFindAll(){
        assertEquals(4,userService.getAllUsers().size());
    }

}
