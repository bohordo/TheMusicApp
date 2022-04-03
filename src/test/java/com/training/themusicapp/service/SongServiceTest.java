package com.training.themusicapp.service;

import com.training.themusicapp.TheMusicAppApplication;
import com.training.themusicapp.repository.SongRepository;
import com.training.themusicapp.repository.entity.SongEntity;
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
public class SongServiceTest {

    @MockBean
    SongRepository songRepository;

    @Autowired
    SongService songService;

    List<SongEntity> songEntityListOne;
    List<SongEntity> songEntityListFive;
    List<SongEntity> songEntityListTen;
    List<SongEntity> songEntityListFifteen;

    @Before
    public void setUp(){
        songEntityListOne = new ArrayList<>();
        songEntityListFive = new ArrayList<>();
        songEntityListTen = new ArrayList<>();
        songEntityListFifteen = new ArrayList<>();

        SongEntity songEntityOne = new SongEntity();
        songEntityOne.setId("1");
        songEntityOne.setName("song-one");
        songEntityOne.setArtists("artist-one");
        songEntityOne.setNumberOfLikes(1);
        songEntityListOne.add(songEntityOne);
        songEntityListFive.add(songEntityOne);
        songEntityListTen.add(songEntityOne);
        songEntityListFifteen.add(songEntityOne);

        Iterable<SongEntity> songEntityIterable = songEntityListOne;
        Mockito.when(songRepository.findAll()).thenReturn(songEntityIterable);

        SongEntity songEntityTwo = new SongEntity();
        songEntityTwo.setId("2");
        songEntityTwo.setName("song-two");
        songEntityTwo.setArtists("artist-two");
        songEntityTwo.setNumberOfLikes(2);
        songEntityListFive.add(songEntityTwo);
        songEntityListTen.add(songEntityTwo);
        songEntityListFifteen.add(songEntityTwo);

        SongEntity songEntityThree = new SongEntity();
        songEntityThree.setId("3");
        songEntityThree.setName("song-three");
        songEntityThree.setArtists("artist-three");
        songEntityThree.setNumberOfLikes(3);
        songEntityListFive.add(songEntityThree);
        songEntityListTen.add(songEntityThree);
        songEntityListFifteen.add(songEntityThree);

        SongEntity songEntityFour = new SongEntity();
        songEntityFour.setId("4");
        songEntityFour.setName("song-four");
        songEntityFour.setArtists("artist-four");
        songEntityFour.setNumberOfLikes(4);
        songEntityListFive.add(songEntityFour);
        songEntityListTen.add(songEntityFour);
        songEntityListFifteen.add(songEntityFour);

        SongEntity songEntityFive = new SongEntity();
        songEntityFive.setId("5");
        songEntityFive.setName("song-five");
        songEntityFive.setArtists("artist-five");
        songEntityFive.setNumberOfLikes(5);
        songEntityListFive.add(songEntityFive);
        songEntityListTen.add(songEntityFive);
        songEntityListFifteen.add(songEntityFive);

        Mockito.when(songRepository.findTop5ByOrderByNumberOfLikesDesc()).thenReturn(songEntityListFive);

        SongEntity songEntitySix = new SongEntity();
        songEntitySix.setId("1");
        songEntitySix.setName("song-six");
        songEntitySix.setArtists("artist-six");
        songEntitySix.setNumberOfLikes(6);
        songEntityListTen.add(songEntitySix);
        songEntityListFifteen.add(songEntitySix);

        SongEntity songEntitySeven = new SongEntity();
        songEntitySeven.setId("1");
        songEntitySeven.setName("song-seven");
        songEntitySeven.setArtists("artist-seven");
        songEntitySeven.setNumberOfLikes(7);
        songEntityListTen.add(songEntitySeven);
        songEntityListFifteen.add(songEntitySeven);

        SongEntity songEntityEight = new SongEntity();
        songEntityEight.setId("8");
        songEntityEight.setName("song-eight");
        songEntityEight.setArtists("artist-eight");
        songEntityEight.setNumberOfLikes(8);
        songEntityListTen.add(songEntityEight);
        songEntityListFifteen.add(songEntityEight);

        SongEntity songEntityNine = new SongEntity();
        songEntityNine.setId("1");
        songEntityNine.setName("song-nine");
        songEntityNine.setArtists("artist-nine");
        songEntityNine.setNumberOfLikes(9);
        songEntityListTen.add(songEntityNine);
        songEntityListFifteen.add(songEntityNine);

        SongEntity songEntityTeen = new SongEntity();
        songEntityTeen.setId("10");
        songEntityTeen.setName("song-ten");
        songEntityTeen.setArtists("artist-ten");
        songEntityTeen.setNumberOfLikes(10);
        songEntityListTen.add(songEntityTeen);
        songEntityListFifteen.add(songEntityTeen);

        Mockito.when(songRepository.findTop10ByOrderByNumberOfLikesDesc()).thenReturn(songEntityListTen);

        SongEntity songEntityEleven = new SongEntity();
        songEntityEleven.setId("11");
        songEntityEleven.setName("song-eleven");
        songEntityEleven.setArtists("artist-eleven");
        songEntityEleven.setNumberOfLikes(11);
        songEntityListFifteen.add(songEntityEleven);

        SongEntity songEntityTwelve = new SongEntity();
        songEntityTwelve.setId("12");
        songEntityTwelve.setName("song-twelve");
        songEntityTwelve.setArtists("artist-twelve");
        songEntityTwelve.setNumberOfLikes(12);
        songEntityListFifteen.add(songEntityTwelve);

        SongEntity songEntityThirteen = new SongEntity();
        songEntityThirteen.setId("11");
        songEntityThirteen.setName("song-thirteen");
        songEntityThirteen.setArtists("artist-thirteen");
        songEntityThirteen.setNumberOfLikes(13);
        songEntityListFifteen.add(songEntityThirteen);

        SongEntity songEntityFourteen = new SongEntity();
        songEntityFourteen.setId("14");
        songEntityFourteen.setName("song-fourteen");
        songEntityFourteen.setArtists("artist-fourteen");
        songEntityFourteen.setNumberOfLikes(14);
        songEntityListFifteen.add(songEntityFourteen);

        SongEntity songEntityFifteen = new SongEntity();
        songEntityFifteen.setId("15");
        songEntityFifteen.setName("song-fifteen");
        songEntityFifteen.setArtists("artist-fifteen");
        songEntityFifteen.setNumberOfLikes(15);
        songEntityListFifteen.add(songEntityFifteen);

        Mockito.when(songRepository.findTop15ByOrderByNumberOfLikesDesc()).thenReturn(songEntityListFifteen);
    }


    @Test
    public void getSongsAll(){
        assertEquals(1,songService.getSongs("1").size());
    }

    @Test
    public void getSongsFive(){
        assertEquals(5,songService.getSongs("5").size());
    }

    @Test
    public void getSongsTen(){
        assertEquals(10,songService.getSongs("10").size());
    }

    @Test
    public void getSongsFifteen(){
        assertEquals(15,songService.getSongs("15").size());
    }

    @Test
    public void getAllSongs(){
        assertEquals(1,songService.getAllSongs().size());
    }

    @Test
    public void getTopFive(){
        assertEquals(5,songService.getTopFive().size());
    }

    @Test
    public void getTopTen(){
        assertEquals(10,songService.getTopTen().size());
    }
    @Test
    public void getTopFifteen(){
        assertEquals(15,songService.getTopFifteen().size());
    }
}
