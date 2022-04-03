package com.training.themusicapp.repository;

import com.training.themusicapp.repository.entity.SongEntity;
import org.junit.Assert;
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
public class SongRepositoryTest {

    @Autowired
    SongRepository songRepository;

    List<SongEntity> songEntityList;

    @Before
    public void setUp(){
        songEntityList = new ArrayList<>();
        SongEntity songEntity = new SongEntity();
        songEntity.setId("1");
        songEntity.setName("song-one");
        songEntity.setArtists("artist-one");
        songEntity.setNumberOfLikes(1);
        songEntityList.add(songEntity);
        songRepository.saveAll(songEntityList);
    }

    @Test
    public void songRepositoryTest(){
        List<SongEntity> songEntity = (List<SongEntity>) songRepository.findAll();
        assertEquals("1",songEntity.get(0).getId());
        assertEquals("song-one",songEntity.get(0).getName());
        assertEquals("artist-one",songEntity.get(0).getArtists());
        assertEquals(1,songEntity.get(0).getNumberOfLikes());
    }
}
