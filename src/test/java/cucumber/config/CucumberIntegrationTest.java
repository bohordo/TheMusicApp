package cucumber.config;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"classpath:features"},
                 glue = {"classpath:cucumber/steps" })
public class CucumberIntegrationTest {
}
