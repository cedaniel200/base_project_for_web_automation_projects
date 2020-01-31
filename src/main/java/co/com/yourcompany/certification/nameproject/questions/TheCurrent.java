package co.com.yourcompany.certification.nameproject.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.thucydides.core.webdriver.SerenityWebdriverManager;

@Subject("the current URL")
public class TheCurrent implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return SerenityWebdriverManager.inThisTestThread().getCurrentDriver().getCurrentUrl();
    }

    public static Question<String> url() {
        return new TheCurrent();
    }
}
