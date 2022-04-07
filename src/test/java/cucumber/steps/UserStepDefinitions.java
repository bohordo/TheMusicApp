package cucumber.steps;

import com.training.themusicapp.service.domain.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class UserStepDefinitions {

    User user;
    Integer numberOfLikes;

    @Given("I have a user")
    public void i_have_a_calculator(){
        user = new User();
    }

    @When("I add {int} to the liked songs")
    public void i_add_and(Integer int1){
        user.setTotalNumberOfLikes(int1);
        numberOfLikes = user.getTotalNumberOfLikes();
    }

    @Then("I should get {int}")
    public void i_should_get(Integer expectedResult){
        assertThat(expectedResult).isEqualTo(numberOfLikes);
    }

}
