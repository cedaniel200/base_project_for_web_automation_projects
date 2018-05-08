package co.com.your_company.certification.name_project.step_definitions;

import co.com.your_company.certification.name_project.model.User;
import co.com.your_company.certification.name_project.model.enumerables.GitIgnore;
import co.com.your_company.certification.name_project.model.enumerables.License;
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

import static co.com.your_company.certification.name_project.model.builders.RepositoryBuilder.name;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.core.Is.is;

public class CreateRepositoryInGitHubStepDefinition {

    @Managed(driver = "chrome")
    private WebDriver hisBrowser;
    private Actor cesar = Actor.named("Cesar");

    @Before
    public void jamesCanBrowseTheWeb() {
       cesar.can(BrowseTheWeb.with(hisBrowser));
    }

    @Given("^I want to start versioning$")
    public void i_want_to_start_versioning() throws Exception {
        User user = new User("YOUR_USERNAME", "YOUR_PASSWORD");
        cesar.wasAbleTo(Start.withAnAuthenticatedUser(user));
    }

    @When("^you create a repository in github$")
    public void when_you_create_a_repository_in_github() throws Exception {
        cesar.attemptsTo(CreateRepository.withTheFollowingData(
                name("TEST_BDD")
                        .description("repository for bdd tests")
                        .initializeWithREADME()
                        .gitIgnore(GitIgnore.JAVA)
                        .license(License.MIT)
                        .build()));
    }

    @Then("^I should see the repository created$")
    public void i_should_see_the_repositiorio_created() throws Exception {
        cesar.should(seeThat(TheRepository.name(), is("TEST_BDD")));
    }

}
