package co.com.yourcompany.certification.nameproject.interactions;

import net.serenitybdd.screenplay.actions.EnterValue;
import net.serenitybdd.screenplay.targets.Target;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EnterAndHide {

    private final String theText;
    private String mask;

    private EnterAndHide(String text) {
        this.theText = text;
        this.mask = "any text";
    }

    public static EnterAndHide theValue(String text) {
        return new EnterAndHide(text);
    }

    public EnterAndHide as(String mask) {
        this.mask = mask;
        return this;
    }

    public EnterValue into(String cssOrXpathForElement) {
        return instrumented(EnterAndHideIntoTarget.class, theText, mask, Target.the(cssOrXpathForElement).locatedBy(cssOrXpathForElement));
    }

    public EnterValue into(Target target) {
        return instrumented(EnterAndHideIntoTarget.class, theText, mask, target);
    }

}
