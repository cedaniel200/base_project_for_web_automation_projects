package co.com.your_company.certification.name_project.tasks;

import co.com.your_company.certification.name_project.exceptions.StartException;
import co.com.your_company.certification.name_project.model.User;
import co.com.your_company.certification.name_project.user_interface.GitHubLoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hover;
import net.serenitybdd.screenplay.actions.Open;

import static co.com.your_company.certification.name_project.model.builders.UserBuilder.theUser;
import static co.com.your_company.certification.name_project.user_interface.GitHubHomePage.DASHBOARD;
import static co.com.your_company.certification.name_project.user_interface.GitHubLoginPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Start implements Task {

    private static final String USERNAME = "DEFAULT_USERNAME";
    private static final String USER_PASSWORD = "DEFAULT_PASSWORD";
    private final User user;
    private GitHubLoginPage gitHubLoginPage;

    public Start(User user){
        this.user = user;
    }

    public static Start authenticating(User user) {
        return instrumented(Start.class, user);
    }

    public static Start withAnAuthenticatedDefaultUser() {
        return instrumented(Start.class, theUser(USERNAME).withPassword(USER_PASSWORD));
    }

    public static Start withoutAuthenticating(){
        return instrumented(Start.class,  null);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        loadLoginPage(actor);
        if(this.user != null){
            authenticateUser(actor);
        }
    }

    private <T extends Actor> void loadLoginPage(T actor) {
        try{
            tryLoadLoginPage(actor);
        }catch (Exception e){
            throw new StartException(StartException.MESSAGE_LOGIN_PAGE_NOT_LOADED, e);
        }
    }

    private <T extends Actor> void tryLoadLoginPage(T actor) {
        actor.attemptsTo(Open.browserOn().the(gitHubLoginPage));
    }

    private <T extends Actor> void authenticateUser(T actor) {
        try{
            tryAuthenticateUser(actor);
        }catch (Exception e){
            throw new StartException(StartException.MESSAGE_FAILED_AUTHENTICATION, e);
        }
    }

    private <T extends Actor> void tryAuthenticateUser(T actor) {
        actor.attemptsTo(
                Enter.theValue(user.getUsername()).into(USERNAME_OR_EMAIL_ADDRESS),
                Enter.theValue(user.getPassword()).into(PASSWORD),
                Click.on(SIGN_IN),
                Hover.over(DASHBOARD));
    }
}
