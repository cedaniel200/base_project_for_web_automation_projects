package co.com.your_company.certification.name_project.runners;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions( features="src/test/resources/features",
        glue = { "co.com.your_company.certification.name_project.step_definitions" })
public class GitHubTestRunner {

}
