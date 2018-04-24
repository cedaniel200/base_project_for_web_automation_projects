package co.com.your_company.certification.name_project.tasks;

import co.com.your_company.certification.name_project.exceptions.RepositoryAlreadyExistsException;
import co.com.your_company.certification.name_project.interactions.SelectDropDownButton;
import co.com.your_company.certification.name_project.model.Repository;
import co.com.your_company.certification.name_project.model.enumerables.GitIgnore;
import co.com.your_company.certification.name_project.model.enumerables.License;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.util.ArrayList;

import static co.com.your_company.certification.name_project.user_interface.CreateNewRepositoryPage.*;
import static co.com.your_company.certification.name_project.user_interface.GitHubHomePage.NEW_REPOSITORY;
import static co.com.your_company.certification.name_project.util.validations.Validations.isEmptyOrNull;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CreateRepository implements Task {

    private final Performable[] interactions;
    private final Repository repository;

    public CreateRepository(Repository repository) {
        this.repository = repository;
        interactions = getInteractionsToPerform();
    }

    private Performable[] getInteractionsToPerform() {
        ArrayList<Performable> interactions = new ArrayList<>();

        interactions.add(Click.on(NEW_REPOSITORY));
        interactions.add(Enter.theValue(repository.getName()).into(REPOSITORY_NAME));
        if(!isEmptyOrNull(repository.getDescription())){
            interactions.add(Enter.theValue(repository.getDescription()).into(REPOSITORY_DESCRIPTION));
        }
        if(repository.isInitializeWithREADME()){
            interactions.add(Click.on(INITIALIZE_THIS_REPOSITORY_WITH_README));
        }
        if(!repository.getGitIgnore().equals(GitIgnore.NONE)){
            interactions.add(SelectDropDownButton.addGitIgnoreWithFilter(repository.getGitIgnore().toString()));
        }
        if(!repository.getLicense().equals(License.NONE)){
            interactions.add(SelectDropDownButton.addLicenseWithFilter(repository.getLicense().toString()));
        }
        interactions.add(Click.on(CREATE_REPOSITORY));

        return interactions.toArray(new Performable[0]);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try{
            actor.attemptsTo(interactions);
        }catch (Exception e){
            throw new RepositoryAlreadyExistsException(repository.getName(), e);
        }
    }

    public static CreateRepository withTheFollowingData(Repository repository){
        return instrumented(CreateRepository.class, repository);
    }

}
