package co.com.your_company.certification.name_project.user_interface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("https://github.com/new")
public class CreateNewRepositoryPage extends PageObject {
    public static final Target REPOSITORY_NAME = Target.the("repository name")
            .located(By.id("repository_name"));
    public static final Target REPOSITORY_DESCRIPTION = Target.the("repository description")
            .located(By.id("repository_description"));
    public static final Target INITIALIZE_THIS_REPOSITORY_WITH_README = Target
            .the("Initialize this repository with a README")
            .located(By.id("repository_auto_init"));
    public static final Target ADD_GITIGNORE = Target
            .the("Add .gitignore")
            .locatedBy("#new_repository > div.with-permission-fields > ul > li:nth-child(1) > div > button");
    public static final Target ADD_LICENSE = Target
            .the("Add a license")
            .locatedBy("//*[@id=\"new_repository\"]/div[3]/ul/li[2]/div/button");
    public static final Target CREATE_REPOSITORY = Target
            .the("Create repository")
            .locatedBy("//*[@id=\"new_repository\"]/div[3]/button");

    public static final Target FILTER_GITIGNORE = Target
            .the("filter of the gitignore")
            .located(By.id("context-ignore-filter-field"));

    public static final Target FILTER_LICENSE = Target
            .the("filter of the license")
            .located(By.id("context-license-filter-field"));

}