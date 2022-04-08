package cucumber.config;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"classpath:features"},
                 glue = {"classpath:cucumber/steps" })

/*
@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("bdd")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME,
        value = "pretty")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME,
        value = "usage")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME,
        value = "html:target/cucumber-reports")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME,
        value = "myproject.cucumber.glue")*/
//@CucumberContextConfiguration
//@SpringBootTest(classes = SpringIntegrationTest.class)
public class CucumberIntegrationTest {
}
