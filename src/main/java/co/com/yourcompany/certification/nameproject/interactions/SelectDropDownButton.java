package co.com.yourcompany.certification.nameproject.interactions;

import co.com.yourcompany.certification.nameproject.model.enumerables.GitIgnore;
import co.com.yourcompany.certification.nameproject.model.enumerables.License;
import co.com.yourcompany.certification.nameproject.userinterface.CreateNewRepositoryPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebElement;

import java.util.concurrent.Callable;

import static co.com.yourcompany.certification.nameproject.userinterface.CreateNewRepositoryPage.CSS_SELECTOR_FORMAT_GITIGNORE;
import static co.com.yourcompany.certification.nameproject.userinterface.CreateNewRepositoryPage.CSS_SELECTOR_FORMAT_LICENSE;
import static java.util.concurrent.TimeUnit.SECONDS;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.awaitility.Awaitility.await;

public class SelectDropDownButton implements Interaction {

    private final Target button;
    private final Target filter;
    private final String valueFilter;
    private final String cssSelectorForElementSelected;

    public SelectDropDownButton(Target button, Target filter, String valueFilter, String cssSelectorForElementSelected) {
        this.valueFilter = valueFilter;
        this.button = button;
        this.filter = filter;
        this.cssSelectorForElementSelected = cssSelectorForElementSelected;
    }

    public static SelectDropDownButton addGitIgnoreFilteringBy(GitIgnore valueFilter) {
        return instrumented(SelectDropDownButton.class, CreateNewRepositoryPage.ADD_GITIGNORE,
                CreateNewRepositoryPage.FILTER_GITIGNORE, valueFilter.toString(),
                CSS_SELECTOR_FORMAT_GITIGNORE);
    }

    public static SelectDropDownButton addLicenseFilteringBy(License valueFilter) {
        return instrumented(SelectDropDownButton.class, CreateNewRepositoryPage.ADD_LICENSE,
                CreateNewRepositoryPage.FILTER_LICENSE, valueFilter.toString(),
                CSS_SELECTOR_FORMAT_LICENSE);
    }

    @Override
    @Step("{0} clicks on #button is filtered by #valueFilter and click on the resulting item")
    public <T extends Actor> void performAs(T actor) {
        button.resolveFor(actor).click();
        filter.resolveFor(actor).sendKeys(valueFilter);
        Target selectedItem = Target.the("selected item").locatedBy(cssSelectorForElementSelected);
        await().forever().pollInterval(1, SECONDS).until(isNotNull(selectedItem.resolveFor(actor)));
        selectedItem.resolveFor(actor).click();
    }

    private Callable<Boolean> isNotNull(WebElement element) {
        return () -> element != null;
    }
}
