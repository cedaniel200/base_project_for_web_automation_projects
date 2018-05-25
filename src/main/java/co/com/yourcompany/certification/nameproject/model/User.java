package co.com.yourcompany.certification.nameproject.model;

import co.com.yourcompany.certification.nameproject.exceptions.UserModelCreationException;
import co.com.yourcompany.certification.nameproject.model.builders.UserBuilder;

import static co.com.yourcompany.certification.nameproject.util.validations.Validations.isEmptyOrNull;

public class User {

    private final String username;
    private final String password;

    public User(UserBuilder builder) throws UserModelCreationException {
        this.username = builder.getUsername();
        this.password = builder.getPassword();
        isValid();
    }

    private void isValid() throws UserModelCreationException {
        if(isEmptyOrNull(username) ||
                isEmptyOrNull(password)){
            throw new UserModelCreationException("Invalid username or password");
        }
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}