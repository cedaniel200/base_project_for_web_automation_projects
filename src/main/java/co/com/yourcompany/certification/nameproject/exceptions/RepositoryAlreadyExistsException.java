package co.com.yourcompany.certification.nameproject.exceptions;

public class RepositoryAlreadyExistsException extends AssertionError {

    private static final String MESSAGE_FORMAT_REPOSITORY_ALREADY_EXISTS = "The repository named %s already exists";

    public RepositoryAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public static String getMessage(String repositoryName){
        return String.format(MESSAGE_FORMAT_REPOSITORY_ALREADY_EXISTS, repositoryName);
    }

}
