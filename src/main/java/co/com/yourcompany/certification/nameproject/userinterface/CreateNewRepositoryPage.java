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
            .locatedBy("//*[@id=\"new_repository\"]/div[3]/div[4]/ul/li[1]/details/summary");

    public static final Target ADD_LICENSE = Target
            .the("Add a license")
            .locatedBy("//*[@id=\"new_repository\"]/div[3]/div[4]/ul/li[2]/details/summary");

    public static final Target FILTER_GITIGNORE = Target
            .the("filter of the gitignore")
            .located(By.id("context-ignore-filter-field"));

    public static final Target FILTER_LICENSE = Target
            .the("filter of the license")
            .locatedBy("//*[@id=\"repo-new-license-details\"]/div/div/filter-input/input");

    public static final String SELECTOR_FORMAT_GITIGNORE = "#new_repository > div.js-with-permission-fields > div.js-repository-auto-init-options > ul > li:nth-child(1) > " +
            "details > details-menu > div.select-menu-list > div.filterable-active";

    public static final String SELECTOR_FORMAT_LICENSE = "//label[@aria-selected='true']";

    public static final Target CREATE_REPOSITORY = Target
            .the("Create repository")
            .locatedBy("//*[@id=\"new_repository\"]/div[3]/button");

    public static final Target MESSAGE_REPOSITORY_ALREADY_EXISTS = Target
            .the("Error message")
            .locatedBy("//*[@id=\"new_repository\"]/div[2]/auto-check/dl/dd[2]");
}