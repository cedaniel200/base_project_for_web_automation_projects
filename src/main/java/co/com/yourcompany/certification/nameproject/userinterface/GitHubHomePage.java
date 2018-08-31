package co.com.yourcompany.certification.nameproject.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;


@DefaultUrl("https://github.com/")
public class GitHubHomePage extends PageObject{
    public static final Target NEW_REPOSITORY = Target.the("New repository")
            .located(By.linkText("New repository"));

    public static final Target DASHBOARD = Target.the("Dashboard  of the home page")
            .located(By.id("dashboard"));
}