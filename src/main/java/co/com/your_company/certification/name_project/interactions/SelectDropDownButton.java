package co.com.your_company.certification.name_project.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

import static co.com.your_company.certification.name_project.user_interface.CreateNewRepositoryPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectDropDownButton implements Interaction {

    private static final String CSS_SELECTOR_FORMAT = "#new_repository > div.with-permission-fields > ul > " +
            "li:nth-child(%d) " +
            "> div > div > div > div.select-menu-list > div.filterable-active";

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

    public static SelectDropDownButton addGitIgnoreWithFilter(String valueFilter) {
        return instrumented(SelectDropDownButton.class, ADD_GITIGNORE,  FILTER_GITIGNORE, valueFilter,
                String.format(CSS_SELECTOR_FORMAT, 1));
    }

    public static SelectDropDownButton addLicenseWithFilter(String valueFilter) {
        return instrumented(SelectDropDownButton.class, ADD_LICENSE,  FILTER_LICENSE, valueFilter,
                String.format(CSS_SELECTOR_FORMAT, 2));
    }

    @Override
    @Step("{0} clicks on #button is filtered by #valueFilter and click on the resulting item")
    public <T extends Actor> void performAs(T actor) {
        button.resolveFor(actor).click();
        filter.resolveFor(actor).sendKeys(valueFilter);
        Target selectedItem = Target.the("selected item").locatedBy(cssSelectorForElementSelected);
        selectedItem.resolveFor(actor).click();
    }
}
