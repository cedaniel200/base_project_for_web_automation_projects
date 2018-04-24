package co.com.your_company.certification.name_project.exceptions;

import net.serenitybdd.core.exceptions.SerenityManagedException;

public class RepositoryAlreadyExistsException extends SerenityManagedException {

    private static final String MESSAGE_FORMAT = "the repository named %s already exists";

    public RepositoryAlreadyExistsException(String nameRepository, Throwable testErrorException) {
        super(String.format(MESSAGE_FORMAT, nameRepository), testErrorException);
    }

}
