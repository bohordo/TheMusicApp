package com.training.themusicapp.service;

import com.training.themusicapp.TheMusicAppApplication;
import com.training.themusicapp.repository.ArtistRepository;
import com.training.themusicapp.repository.entity.ArtistEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TheMusicAppApplication.class})
public class ArtistServiceTest {

    @MockBean
    private ArtistRepository artistRepository;

    @Autowired
    private ArtistService artistService;

    private List<ArtistEntity> artistDtoList;
    private List<ArtistEntity> artistDtoListSizeThree;
    private List<ArtistEntity> artistDtoListSizeFive;

    @Before
    public void setUp(){

        artistDtoList = new ArrayList<>();
        artistDtoListSizeThree = new ArrayList<>();
        artistDtoListSizeFive = new ArrayList<>();

        ArtistEntity artistEntityOne = new ArtistEntity();
        artistEntityOne.setName("artist one");
        artistEntityOne.setTotalNumberOfLikes(1);

        artistDtoList.add(artistEntityOne);
        artistDtoListSizeThree.add(artistEntityOne);
        artistDtoListSizeFive.add(artistEntityOne);

        ArtistEntity artistEntityTwo = new ArtistEntity();
        artistEntityTwo.setName("artist two");
        artistEntityTwo.setTotalNumberOfLikes(1);

        artistDtoList.add(artistEntityTwo);
        artistDtoListSizeThree.add(artistEntityTwo);
        artistDtoListSizeFive.add(artistEntityTwo);

        ArtistEntity artistEntityThree = new ArtistEntity();
        artistEntityThree.setName("artist three");
        artistEntityThree.setTotalNumberOfLikes(1);

        artistDtoList.add(artistEntityThree);
        artistDtoListSizeThree.add(artistEntityThree);
        artistDtoListSizeFive.add(artistEntityThree);

        ArtistEntity artistEntityFour = new ArtistEntity();
        artistEntityFour.setName("artist four");
        artistEntityFour.setTotalNumberOfLikes(1);

        artistDtoList.add(artistEntityFour);
        artistDtoListSizeFive.add(artistEntityFour);


        ArtistEntity artistEntityFive = new ArtistEntity();
        artistEntityFive.setName("artist five");
        artistEntityFive.setTotalNumberOfLikes(1);

        artistDtoList.add(artistEntityFive);
        artistDtoListSizeFive.add(artistEntityFive);

        ArtistEntity artistEntitySix = new ArtistEntity();
        artistEntitySix.setName("artist six");
        artistEntitySix.setTotalNumberOfLikes(1);

        artistDtoList.add(artistEntitySix);

        Iterable<ArtistEntity> artistEntityIterable = artistDtoList;

        Mockito.when(artistRepository.findAll()).thenReturn(artistEntityIterable);
        Mockito.when(artistRepository.findTop3ByOrderByTotalNumberOfLikesDesc()).thenReturn(artistDtoListSizeThree);
        Mockito.when(artistRepository.findTop5ByOrderByTotalNumberOfLikesDesc()).thenReturn(artistDtoListSizeFive);
    }

    @Test
    public void whenGetArtistIsNotTopShouldFindAll(){
        assertEquals(6,artistService.getArtist("1").size());
    }

    @Test
    public void whenGetArtistByThreeShouldGetThree(){
        assertEquals(3,artistService.getArtist("3").size());
    }

    @Test
    public void whenGetArtistByThreeShouldGetFive(){
        assertEquals(5,artistService.getArtist("5").size());
    }

}
