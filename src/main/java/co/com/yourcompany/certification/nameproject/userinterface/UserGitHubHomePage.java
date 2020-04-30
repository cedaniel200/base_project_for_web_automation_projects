package co.com.yourcompany.certification.nameproject.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class UserGitHubHomePage {
    public static final Target NEW_REPOSITORY = Target.the("New repository")
            .located(By.linkText("New"));

    public static final Target DASHBOARD = Target.the("Dashboard  of the home page")
            .located(By.id("dashboard"));
}