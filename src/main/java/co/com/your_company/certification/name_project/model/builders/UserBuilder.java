package co.com.your_company.certification.name_project.model.builders;

import co.com.your_company.certification.name_project.model.User;
import co.com.your_company.certification.name_project.util.builder.Builder;

public class UserBuilder implements Builder<User> {

    private String username;
    private String password;

    private UserBuilder(String username) {
        this.username = username;
    }

    public User withPassword(String password){
        this.password = password;
        return this.build();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public User build() throws IllegalStateException {
        return new User(this);
    }

    public static UserBuilder theUser(String username){
        return new UserBuilder(username);
    }

}
