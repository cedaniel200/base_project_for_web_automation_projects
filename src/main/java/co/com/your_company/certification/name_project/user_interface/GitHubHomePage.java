package co.com.your_company.certification.name_project.user_interface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;


@DefaultUrl("https://github.com/")
public class GitHubHomePage extends PageObject{
    public static final Target NEW_REPOSITORY = Target.the("New repository")
            .locatedBy("//*[@id=\"your_repos\"]/div/div[1]/a");

    public static final Target DASHBOARD = Target.the("Dashboard  of the home page")
            .located(By.id("dashboard"));
}