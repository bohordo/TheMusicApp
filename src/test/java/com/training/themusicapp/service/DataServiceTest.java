package com.training.themusicapp.service;

import com.training.themusicapp.TheMusicAppApplication;
import com.training.themusicapp.repository.ArtistRepository;
import com.training.themusicapp.repository.SongRepository;
import com.training.themusicapp.repository.UserRepository;
import com.training.themusicapp.repository.entity.ArtistEntity;
import com.training.themusicapp.repository.entity.SongEntity;
import com.training.themusicapp.repository.entity.UserEntity;
import com.training.themusicapp.service.domain.Artist;
import com.training.themusicapp.service.domain.Song;
import com.training.themusicapp.service.domain.User;
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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TheMusicAppApplication.class})
public class DataServiceTest {

    @MockBean
    private SongRepository songRepository;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private ArtistRepository artistRepository;

    @Autowired
    DataService dataService;

    @Before
    public void setUp(){
        List<SongEntity> songsEntities = new ArrayList<>();
        songsEntities.add(new SongEntity());
        Iterable<SongEntity> artistEntityIterable = songsEntities;
        Mockito.when(songRepository.findAll()).thenReturn(artistEntityIterable);

        List<UserEntity> UserEntities = new ArrayList<>();
        UserEntities.add(new UserEntity());
        Iterable<UserEntity> userEntitiesIterable = UserEntities;
        Mockito.when(userRepository.findAll()).thenReturn(userEntitiesIterable);

        List<ArtistEntity> artistEntities = new ArrayList<>();
        artistEntities.add(new ArtistEntity());
        Iterable<ArtistEntity> artistEntitiesIterable = artistEntities;
        Mockito.when(artistRepository.findAll()).thenReturn(artistEntitiesIterable);

    }

    @Test
    public void saveSongsDataShouldBeTrue(){
        List<Song> listSong = new ArrayList<>();
        listSong.add(new Song());
        listSong.add(new Song());
        assertTrue(dataService.saveSongsData(listSong));
    }

    @Test
    public void saveSongsDataShouldBeFalse(){
        List<Song> listSong = new ArrayList<>();
        listSong.add(new Song());
        assertFalse(dataService.saveSongsData(listSong));
    }

    @Test
    public void saveUsersDataShouldBeTrue(){
        List<User> listUser = new ArrayList<>();
        listUser.add(new User());
        listUser.add(new User());
        assertTrue(dataService.saveUsersData(listUser));
    }

    @Test
    public void saveUsersDataShouldBeFalse(){
        List<User> listUser = new ArrayList<>();
        listUser.add(new User());
        assertFalse(dataService.saveUsersData(listUser));
    }

    @Test
    public void saveArtistsDataShouldBeTrue(){
        List<Artist> listArtist = new ArrayList<>();
        listArtist.add(new Artist());
        listArtist.add(new Artist());
        assertTrue(dataService.saveArtistData(listArtist));
    }

    @Test
    public void saveArtistsDataShouldBeFalse(){
        List<Artist> listArtist = new ArrayList<>();
        listArtist.add(new Artist());
        assertFalse(dataService.saveArtistData(listArtist));
    }
}
