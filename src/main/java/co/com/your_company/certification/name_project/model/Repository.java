package co.com.your_company.certification.name_project.model;

import co.com.your_company.certification.name_project.model.builders.RepositoryBuilder;
import co.com.your_company.certification.name_project.model.enumerables.GitIgnore;
import co.com.your_company.certification.name_project.model.enumerables.License;

import static co.com.your_company.certification.name_project.util.validations.Validations.isEmptyOrNull;

public class Repository {

    private final String name;
    private final String description;
    private final boolean initializeWithREADME;
    private final GitIgnore gitIgnore;
    private final License license;

    public Repository(RepositoryBuilder builder) throws IllegalStateException {
        name = builder.getName();
        description = builder.getDescription();
        initializeWithREADME = builder.isInitializeWithREADME();
        gitIgnore = builder.getGitIgnore();
        license = builder.getLicense();
        isValid();
    }

    private void isValid() throws IllegalStateException {
        if (isEmptyOrNull(this.name)) {
            throw new IllegalStateException("The repository does not contain a name");
        }
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isInitializeWithREADME() {
        return initializeWithREADME;
    }

    public GitIgnore getGitIgnore() {
        return gitIgnore;
    }

    public License getLicense() {
        return license;
    }
}
