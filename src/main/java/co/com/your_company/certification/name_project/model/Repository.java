package co.com.your_company.certification.name_project.model;

import co.com.your_company.certification.name_project.model.builders.RepositoryBuilder;
import co.com.your_company.certification.name_project.model.enumerables.GitIgnore;
import co.com.your_company.certification.name_project.model.enumerables.License;

public class Repository {

    private final String name;
    private final String description;
    private final boolean initializeWithREADME;
    private final GitIgnore gitIgnore;
    private final License license;

    public Repository(RepositoryBuilder builder) {
        name = builder.getName();
        description = builder.getDescription();
        initializeWithREADME = builder.isInitializeWithREADME();
        gitIgnore = builder.getGitIgnore();
        license = builder.getLicense();
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
