package com.training.themusicapp.repository;

import com.training.themusicapp.repository.entity.ArtistEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ArtistRepositoryTest {

    @Autowired
    ArtistRepository artistRepository;

    private List<ArtistEntity> artistDtoList;

    @Before
    public void setUp(){

        artistDtoList = new ArrayList<>();
        ArtistEntity artistEntityOne = new ArtistEntity();
        artistEntityOne.setId("1");
        artistEntityOne.setName("artist one");
        artistEntityOne.setTotalNumberOfLikes(1);
        ArtistEntity artistEntityTwo = new ArtistEntity();
        artistEntityTwo.setId("2");
        artistEntityTwo.setName("artist two");
        artistEntityTwo.setTotalNumberOfLikes(1);
        ArtistEntity artistEntityThree = new ArtistEntity();
        artistEntityThree.setId("3");
        artistEntityThree.setName("artist one");
        artistEntityThree.setTotalNumberOfLikes(1);
        ArtistEntity artistEntityFour = new ArtistEntity();
        artistEntityFour.setId("4");
        artistEntityFour.setName("artist one");
        artistEntityFour.setTotalNumberOfLikes(1);
        ArtistEntity artistEntityFive = new ArtistEntity();
        artistEntityFive.setId("5");
        artistEntityFive.setName("artist one");
        artistEntityFive.setTotalNumberOfLikes(1);
        ArtistEntity artistEntitySix = new ArtistEntity();
        artistEntitySix.setId("6");
        artistEntitySix.setName("artist one");
        artistEntitySix.setTotalNumberOfLikes(1);

        artistDtoList.add(artistEntityOne);
        artistDtoList.add(artistEntityTwo);
        artistDtoList.add(artistEntityThree);
        artistDtoList.add(artistEntityFour);
        artistDtoList.add(artistEntityFive);
        artistDtoList.add(artistEntitySix);
        artistRepository.saveAll(artistDtoList);
    }

    @Test
    public void artistRepositoryFindAllTest(){
        List<ArtistEntity> artistEntityList = (List<ArtistEntity>) artistRepository.findAll();
        assertEquals("artist one",artistEntityList.get(0).getName());
        assertEquals(1,artistEntityList.get(0).getTotalNumberOfLikes());
        assertThat(artistRepository.findAll()).isNotEmpty();
    }

    @Test
    public void findTop3ByOrderByTotalNumberOfLikesDescTest(){
        assertThat(artistRepository.findTop3ByOrderByTotalNumberOfLikesDesc()).isNotEmpty();
    }

    @Test
    public void findTop5ByOrderByTotalNumberOfLikesDescTest(){
        assertThat(artistRepository.findTop5ByOrderByTotalNumberOfLikesDesc()).isNotEmpty();
    }
}
