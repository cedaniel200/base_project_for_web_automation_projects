package co.com.yourcompany.certification.nameproject.runners;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions( features="src/test/resources/features",
        glue = { "co.com.yourcompany.certification.nameproject.stepdefinitions" })
public class GitHubTestRunner {

}
