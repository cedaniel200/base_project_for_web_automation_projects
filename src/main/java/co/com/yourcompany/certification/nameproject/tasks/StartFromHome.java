package co.com.yourcompany.certification.nameproject.tasks;

import co.com.yourcompany.certification.nameproject.exceptions.StartError;
import co.com.yourcompany.certification.nameproject.exceptions.UserModelCreationException;
import co.com.yourcompany.certification.nameproject.interactions.EnterAndHide;
import co.com.yourcompany.certification.nameproject.model.User;
import co.com.yourcompany.certification.nameproject.userinterface.GitHubHomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

import java.time.Duration;

import static co.com.yourcompany.certification.nameproject.exceptions.StartError.MESSAGE_FAILED_AUTHENTICATION;
import static co.com.yourcompany.certification.nameproject.model.builders.UserBuilder.theUser;
import static co.com.yourcompany.certification.nameproject.userinterface.GitHubHomePage.GO_TO_SIGN_IN;
import static co.com.yourcompany.certification.nameproject.userinterface.GitHubLoginPage.*;
import static co.com.yourcompany.certification.nameproject.userinterface.UserGitHubHomePage.DASHBOARD;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class StartFromHome implements Task {

    private static final String USERNAME = "DEFAULT_USERNAME";
    private static final String USER_PASSWORD = "DEFAULT_PASSWORD";
    private final User user;
    private GitHubHomePage gitHubHomePage;

    public StartFromHome(User user) {
        this.user = user;
    }

    @Override
    @Step("{0} performs an authentication")
    public <T extends Actor> void performAs(T theActor) {
        theActor.attemptsTo(Open.browserOn(gitHubHomePage));

        theActor.should(seeThat(the(GO_TO_SIGN_IN.waitingForNoMoreThan(Duration.ofSeconds(5))), isVisible()));

        theActor.attemptsTo(
                Click.on(GO_TO_SIGN_IN)
        );

        theActor.attemptsTo(
                Enter.theValue(user.getUsername()).into(USERNAME_OR_EMAIL_ADDRESS),
                EnterAndHide.theValue(user.getPassword()).as("a password").into(PASSWORD),
                Click.on(SIGN_IN));

        theActor.should(seeThat(the(DASHBOARD), isVisible())
                .orComplainWith(StartError.class,
                        MESSAGE_FAILED_AUTHENTICATION));
    }

    public static StartFromHome authenticating(User user) {
        return instrumented(StartFromHome.class, user);
    }

    public static StartFromHome withAnAuthenticatedDefaultUser() throws UserModelCreationException {
        return instrumented(StartFromHome.class, theUser(USERNAME).withPassword(USER_PASSWORD));
    }

}
