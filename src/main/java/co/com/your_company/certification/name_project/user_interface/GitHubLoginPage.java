package co.com.your_company.certification.name_project.user_interface;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

@DefaultUrl("https://github.com/login")
public class GitHubLoginPage extends PageObject {
    public static final Target USERNAME_OR_EMAIL_ADDRESS = Target.the("Username or email address")
                                                            .located(By.id("login_field"));
    public static final Target PASSWORD = Target.the("Password").located(By.id("password"));
    public static final Target SIGN_IN = Target.the("Sign in").located(By.name("commit"));

}
