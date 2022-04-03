package com.training.themusicapp.repository;

import com.training.themusicapp.repository.entity.UserSongEntity;
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
public class UserSongRepositoryTest {

    @Autowired
    UserSongRepository userSongRepository;

    List<UserSongEntity> userSongEntitiesList;

    @Before
    public void setUp(){
        userSongEntitiesList = new ArrayList<>();
        UserSongEntity userSongEntity = new UserSongEntity();
        userSongEntity.setId("11");
        userSongEntity.setUserId("1");
        userSongEntity.setSongId("1");
        userSongEntitiesList.add(userSongEntity);
        userSongRepository.saveAll(userSongEntitiesList);
    }

    @Test
    public void userRepositoryTest(){
        List<UserSongEntity> userSongEntities = (List<UserSongEntity>) userSongRepository.findAll();
        assertEquals("11",userSongEntities.get(0).getId());
        assertEquals("1",userSongEntities.get(0).getSongId());
        assertEquals("1",userSongEntities.get(0).getSongId());
    }
}
