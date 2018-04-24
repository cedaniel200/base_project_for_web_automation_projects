package co.com.your_company.certification.name_project.user_interface;

import net.serenitybdd.screenplay.targets.Target;

public class RepositoryPage {
    public static final Target REPOSITORY_NAME = Target.the("repository name")
            .locatedBy("//*[@id=\"js-repo-pjax-container\"]/div[1]/div/h1/strong/a");
}
