package co.com.yourcompany.certification.nameproject.exceptions;

public class StartError extends AssertionError  {

    public static final String MESSAGE_LOGIN_PAGE_NOT_LOADED = "The login page could not be loaded";
    public static final String MESSAGE_FAILED_AUTHENTICATION = "Authentication failed";

    public StartError(String message, Throwable cause) {
        super(message, cause);
    }
}