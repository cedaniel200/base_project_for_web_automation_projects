package co.com.yourcompany.certification.nameproject.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("https://github.com")
public class GitHubHomePage extends PageObject {
    public static final Target GO_TO_SIGN_IN = Target.the("go to sign in")
            .located(By.linkText("Ssign in")); // Error voluntario para generar la excepción
}
