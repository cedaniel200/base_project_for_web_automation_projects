package co.com.yourcompany.certification.nameproject.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class RepositoryPage {
    public static final Target REPOSITORY_NAME = Target.the("repository name")
            .locatedBy("//*[@id=\"js-repo-pjax-container\"]//strong[@itemprop='name']/a");
}
