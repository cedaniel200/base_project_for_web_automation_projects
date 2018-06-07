package co.com.yourcompany.certification.nameproject.exceptions;

public class StartException extends AssertionError  {

    public static final String MESSAGE_LOGIN_PAGE_NOT_LOADED = "The login page could not be loaded";
    public static final String MESSAGE_FAILED_AUTHENTICATION = "Authentication failed";

    public StartException(String message, Throwable cause) {
        super(message, cause);
    }
}