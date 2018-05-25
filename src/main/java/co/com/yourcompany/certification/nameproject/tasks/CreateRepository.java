package co.com.yourcompany.certification.nameproject.tasks;

import co.com.yourcompany.certification.nameproject.exceptions.RepositoryAlreadyExistsException;
import co.com.yourcompany.certification.nameproject.exceptions.RepositoryModelCreationException;
import co.com.yourcompany.certification.nameproject.interactions.SelectDropDownButton;
import co.com.yourcompany.certification.nameproject.model.Repository;
import co.com.yourcompany.certification.nameproject.model.enumerables.GitIgnore;
import co.com.yourcompany.certification.nameproject.model.enumerables.License;
import co.com.yourcompany.certification.nameproject.util.builder.Builder;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.util.ArrayList;

import static co.com.yourcompany.certification.nameproject.userinterface.CreateNewRepositoryPage.*;
import static co.com.yourcompany.certification.nameproject.userinterface.GitHubHomePage.NEW_REPOSITORY;
import static co.com.yourcompany.certification.nameproject.util.validations.Validations.isEmptyOrNull;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CreateRepository implements Task {

    private final Performable[] interactions;
    private final Repository repository;

    public CreateRepository(Repository repository) {
        this.repository = repository;
        interactions = getInteractionsToPerform();
    }

    private Performable[] getInteractionsToPerform() {
        ArrayList<Performable> interactionsToPerform = new ArrayList<>();

        interactionsToPerform.add(Click.on(NEW_REPOSITORY));
        interactionsToPerform.add(Enter.theValue(repository.getName()).into(REPOSITORY_NAME));
        if(!isEmptyOrNull(repository.getDescription())){
            interactionsToPerform.add(Enter.theValue(repository.getDescription()).into(REPOSITORY_DESCRIPTION));
        }
        if(repository.isInitializeWithREADME()){
            interactionsToPerform.add(Click.on(INITIALIZE_THIS_REPOSITORY_WITH_README));
        }
        if(!repository.getGitIgnore().equals(GitIgnore.NONE)){
            interactionsToPerform.add(SelectDropDownButton.addGitIgnoreWithFilter(repository.getGitIgnore().toString()));
        }
        if(!repository.getLicense().equals(License.NONE)){
            interactionsToPerform.add(SelectDropDownButton.addLicenseWithFilter(repository.getLicense().toString()));
        }
        interactionsToPerform.add(Click.on(CREATE_REPOSITORY));

        return interactionsToPerform.toArray(new Performable[0]);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try{
            actor.attemptsTo(interactions);
        }catch (Exception e){
            throw new RepositoryAlreadyExistsException(repository.getName(), e);
        }
    }

    public static CreateRepository withTheFollowingData(Builder<Repository> builder) throws RepositoryModelCreationException {
        return instrumented(CreateRepository.class, builder.build());
    }

}
