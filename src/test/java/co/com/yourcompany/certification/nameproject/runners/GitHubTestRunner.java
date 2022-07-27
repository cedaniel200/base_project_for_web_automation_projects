package co.com.yourcompany.certification.nameproject.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/create_repository.feature",
        glue = {"co.com.yourcompany.certification.nameproject.stepdefinitions"},
        snippets = CucumberOptions.SnippetType.CAMELCASE)
public class GitHubTestRunner {

}
