package co.com.yourcompany.certification.nameproject.exceptions;

public class RepositoryAlreadyExistsError extends AssertionError {

    private static final String MESSAGE_FORMAT_REPOSITORY_ALREADY_EXISTS = "The repository named %s already exists";

    public RepositoryAlreadyExistsError(String message, Throwable cause) {
        super(message, cause);
    }

    public static String withMessageBy(String repositoryName) {
        return String.format(MESSAGE_FORMAT_REPOSITORY_ALREADY_EXISTS, repositoryName);
    }

}
