package co.com.yourcompany.certification.nameproject.tasks;

import co.com.yourcompany.certification.nameproject.exceptions.StartException;
import co.com.yourcompany.certification.nameproject.exceptions.UserModelCreationException;
import co.com.yourcompany.certification.nameproject.interactions.EnterAndHide;
import co.com.yourcompany.certification.nameproject.model.User;
import co.com.yourcompany.certification.nameproject.userinterface.GitHubLoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;

import static co.com.yourcompany.certification.nameproject.model.builders.UserBuilder.theUser;
import static co.com.yourcompany.certification.nameproject.userinterface.GitHubHomePage.DASHBOARD;
import static co.com.yourcompany.certification.nameproject.userinterface.GitHubLoginPage.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class Start implements Task {

    private static final String USERNAME = "DEFAULT_USERNAME";
    private static final String USER_PASSWORD = "DEFAULT_PASSWORD";
    private final User user;
    private GitHubLoginPage gitHubLoginPage;

    public Start(User user){
        this.user = user;
    }

    public Start(){
        this.user = null;
    }

    public static Start authenticating(User user) {
        return instrumented(Start.class, user);
    }

    public static Start withAnAuthenticatedDefaultUser() throws UserModelCreationException {
        return instrumented(Start.class, theUser(USERNAME).withPassword(USER_PASSWORD));
    }

    public static Start withoutAuthenticating(){
        return instrumented(Start.class);
    }

    @Override
    public <T extends Actor> void performAs(T theActor) {
        loadLoginPage(theActor);
        if(this.user != null){
            authenticateUser(theActor);
        }
    }

    private <T extends Actor> void loadLoginPage(T theActor) {
        theActor.attemptsTo(Open.browserOn().the(gitHubLoginPage));

        theActor.should(seeThat(the(USERNAME_OR_EMAIL_ADDRESS), isVisible())
                .orComplainWith(StartException.class,
                        StartException.MESSAGE_LOGIN_PAGE_NOT_LOADED));
    }

    private <T extends Actor> void authenticateUser(T theActor) {
        theActor.attemptsTo(
                Enter.theValue(user.getUsername()).into(USERNAME_OR_EMAIL_ADDRESS),
                EnterAndHide.theValue(user.getPassword()).as("***").into(PASSWORD),
                Click.on(SIGN_IN));

        theActor.should(seeThat(the(DASHBOARD), isVisible())
                .orComplainWith(StartException.class,
                        StartException.MESSAGE_FAILED_AUTHENTICATION));
    }
}
