package cucumber.steps;

import com.training.themusicapp.repository.UserRepository;
import com.training.themusicapp.repository.entity.UserEntity;
import com.training.themusicapp.service.UserService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class GetTopUsersDefinition {

    @Autowired
    UserRepository userRepository;

    List<UserEntity> userEntitiesList;

    @MockBean
    UserService userService;

    @Autowired
    private MockMvc mockMvc;

    @Given("A data of users is in the database")
    public void a_data_of_users_is_in_the_database() {

        userEntitiesList = new ArrayList<>();
        UserEntity userEntity1 = new UserEntity();
        userEntity1.setId("1");
        userEntity1.setUsername("one");
        userEntity1.setTotalNumberOfLikes(8);
        UserEntity userEntity2 = new UserEntity();
        userEntity2.setId("2");
        userEntity2.setUsername("two");
        userEntity2.setTotalNumberOfLikes(1);
        UserEntity userEntity3 = new UserEntity();
        userEntity3.setId("3");
        userEntity3.setUsername("three");
        userEntity3.setTotalNumberOfLikes(9);
        UserEntity userEntity4 = new UserEntity();
        userEntity4.setId("4");
        userEntity4.setUsername("four");
        userEntity4.setTotalNumberOfLikes(2);
        userRepository.saveAll(userEntitiesList);

    }
    @When("is required to get top {int} of users")
    public void is_required_to_get_top_of_users(Integer int1) throws Exception {
        //userEntitiesList = mockMvc.perform(get("/user/top/"+int1)).andExpect(status().isOk()).getClass().getb;
        mockMvc.perform(get("/user/top/"+int1))
                .andExpect(status().isOk());

    }
    @Then("the system return the top {int} of user")
    public void the_system_return_the_top_of_user(Integer int1) {
        assertThat(userEntitiesList.size()).isEqualTo(int1);
    }
}
