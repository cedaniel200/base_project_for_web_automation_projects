package co.com.your_company.certification.name_project.step_definitions;

import co.com.your_company.certification.name_project.model.User;
import co.com.your_company.certification.name_project.questions.TheRepository;
import co.com.your_company.certification.name_project.tasks.CreateRepository;
import co.com.your_company.certification.name_project.tasks.Start;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static co.com.your_company.certification.name_project.model.builders.RepositoryBuilder.name;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.core.Is.is;

public class CreateRepositoryInGitHubWithDataFromFeatureStepDefinition {

    private static final int CURRENT_USER = 0;
    private static final int NAME_REPOSITORY = 2;
    private static final int DESCRIPTIONI_REPOSITORY = 3;

    @Managed(driver = "chrome")
    private WebDriver hisBrowser;
    private Actor cesar = Actor.named("Daniel");

    @Before
    public void jamesCanBrowseTheWeb() {
        cesar.can(BrowseTheWeb.with(hisBrowser));
    }

    @Given("^I want to start versioning in GitHub$")
    public void i_want_to_start_versioning_in_GitHub(List<User> users) throws Exception {
        cesar.wasAbleTo(Start.authenticating(userCurrentAmong(users)));
    }

    @When("^you create a repository in github with the data$")
    public void you_create_a_repository_in_github_with_the_data(List<String> repositoryData) throws Exception {
        cesar.attemptsTo(CreateRepository.withTheFollowingData(
                name(repositoryData.get(NAME_REPOSITORY))
                        .description(repositoryData.get(DESCRIPTIONI_REPOSITORY))));
    }

    @Then("^I should see the \"([^\"]*)\" repository created$")
    public void i_should_see_the_repository_created(String nameRepository) throws Exception {
        cesar.should(seeThat(TheRepository.name(), is(nameRepository)));
    }

    private User userCurrentAmong(List<User> users){
        return users.get(CURRENT_USER);
    }

}
