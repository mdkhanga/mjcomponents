package com.heavyduty.services.entities;


import com.heavyduty.services.api.User;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class UsersEntity {
    @Id
    private String username;
    private String password;
    private String email;

    public UsersEntity() {

    }
    public UsersEntity(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
