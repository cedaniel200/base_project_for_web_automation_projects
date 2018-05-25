package co.com.your_company.certification.name_project.model;

import co.com.your_company.certification.name_project.model.builders.UserBuilder;

import static co.com.your_company.certification.name_project.util.validations.Validations.isEmptyOrNull;

public class User {

    private final String username;
    private final String password;

    public User(UserBuilder builder) throws IllegalStateException {
        this.username = builder.getUsername();
        this.password = builder.getPassword();
        isValid();
    }

    private void isValid() throws IllegalStateException{
        if(isEmptyOrNull(username) ||
                isEmptyOrNull(password)){
            throw new IllegalStateException("Invalid username or password");
        }
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}