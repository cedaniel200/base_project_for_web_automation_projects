package co.com.yourcompany.certification.nameproject.stepdefinitions;

import co.com.yourcompany.certification.nameproject.questions.TheRepository;
import co.com.yourcompany.certification.nameproject.tasks.CreateRepository;
import co.com.yourcompany.certification.nameproject.tasks.Start;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static co.com.yourcompany.certification.nameproject.model.builders.RepositoryBuilder.name;
import static co.com.yourcompany.certification.nameproject.model.builders.UserBuilder.theUser;
import static co.com.yourcompany.certification.nameproject.model.enumerables.GitIgnore.JAVA;
import static co.com.yourcompany.certification.nameproject.model.enumerables.License.MIT;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.core.Is.is;

public class CreateRepositoryInGitHubStepDefinition {

    @Before
    public void jamesCanBrowseTheWeb() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^I want to start versioning$")
    public void iWantToStartVersioning() throws Exception {
        theActorCalled("Cesar").wasAbleTo(Start.authenticating(theUser("YOUR_USERNAME")
                .withPassword("YOUR_PASSWORD")));
    }

    @When("^you create a repository in github$")
    public void whenYouCreateRepositoryInGithub() throws Exception {
        theActorInTheSpotlight().attemptsTo(CreateRepository.withTheFollowingData(
                name("TEST_BDD")
                        .description("repository for bdd tests")
                        .initializeWithREADME()
                        .gitIgnore(JAVA)
                        .license(MIT)
                )
        );
    }

    @Then("^I should see the repository created$")
    public void iShouldSeeTheRepositiorioCreated() throws Exception {
        theActorInTheSpotlight().should(seeThat(TheRepository.name(), is("TEST_BDD")));
    }

}