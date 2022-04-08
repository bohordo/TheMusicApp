package cucumber.config;

import com.training.themusicapp.repository.ArtistRepository;
import com.training.themusicapp.repository.SongRepository;
import com.training.themusicapp.repository.UserRepository;
import com.training.themusicapp.repository.UserSongRepository;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import io.cucumber.spring.CucumberContextConfiguration;

/*
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("cucumber")
@ContextConfiguration(loader = SpringBootContextLoader.class)
*/

@CucumberContextConfiguration
@SpringBootTest
@ActiveProfiles("test")
public class SpringIntegrationTest {

    @MockBean
    private SongRepository songRepository;
    @MockBean
    private ArtistRepository artistRepository;
    @MockBean
    private UserRepository userRepository;
    @MockBean
    private UserSongRepository userSongRepository;
}
