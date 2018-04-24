package co.com.your_company.certification.name_project.exceptions;

import net.serenitybdd.core.exceptions.SerenityManagedException;

public class StartException extends SerenityManagedException {

    public static final String MESSAGE_LOGIN_PAGE_NOT_LOADED = "The login page could not be loaded";
    public static final String MESSAGE_FAILED_AUTHENTICATION = "Authentication failed";

    public StartException(String message, Throwable testErrorException) {
        super(message, testErrorException);
    }
}
