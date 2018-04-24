package co.com.your_company.certification.name_project.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

import static co.com.your_company.certification.name_project.user_interface.RepositoryPage.REPOSITORY_NAME;

@Subject("the name of the repository")
public class TheRepository implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return REPOSITORY_NAME.resolveFor(actor).getText();
    }

    public static TheRepository name() {
        return new TheRepository();
    }
}