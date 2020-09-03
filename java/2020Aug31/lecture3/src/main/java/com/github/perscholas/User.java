package com.github.perscholas;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by leon on 8/31/2020.
 */
@Entity
public class User {
    @Id
    @NotNull
    @Size(min=5, max=14, message="Username must be between {2} and {1}")
    private String username;
    private String password;

    @EmailConstraint
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
