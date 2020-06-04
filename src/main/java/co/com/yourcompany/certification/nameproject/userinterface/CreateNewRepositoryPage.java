package co.com.yourcompany.certification.nameproject.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CreateNewRepositoryPage {

    public static final Target REPOSITORY_NAME = Target.the("repository name  field")
            .located(By.id("repository_name"));

    public static final Target REPOSITORY_DESCRIPTION = Target.the("repository description field")
            .located(By.id("repository_description"));

    public static final Target INITIALIZE_THIS_REPOSITORY_WITH_README = Target
            .the("Initialize this repository with a README")
            .located(By.id("repository_auto_init"));

    public static final Target ADD_GITIGNORE = Target
            .the("Add .gitignore")
            .locatedBy(".my-3 > .select-menu > .btn");

    public static final Target FILTER_GITIGNORE = Target
            .the("filter of the gitignore").located(By.id("context-ignore-filter-field"));

    public static final String SELECTOR_FORMAT_GITIGNORE = ".filterable-active";

    public static final Target ADD_LICENSE = Target
            .the("Add a license")
            .locatedBy(".btn > .text-normal");

    public static final Target FILTER_LICENSE = Target
            .the("filter of the license")
            .locatedBy(".SelectMenu-filter > .width-full");

    public static final String SELECTOR_FORMAT_LICENSE = "//div[@class=\"SelectMenu-list\"]//span[contains(text(), '%s')]//ancestor::label";

    public static final Target CREATE_REPOSITORY = Target
            .the("Create repository")
            .locatedBy("//*[@id=\"new_repository\"]/div[3]/button");

    public static final Target MESSAGE_REPOSITORY_ALREADY_EXISTS = Target
            .the("Error message")
            .locatedBy(".error > strong");
}