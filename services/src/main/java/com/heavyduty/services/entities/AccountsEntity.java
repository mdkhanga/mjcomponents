package com.heavyduty.services.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "accounts")
public class AccountsEntity {

    @Id
    @Column(name = "accountname")
    private String accountName;

    @Column(name = "username")
    private String userName;
    private String type;
    private float balance;
    private Timestamp updated;

    public AccountsEntity() {

    }

    public AccountsEntity(String name, String user, String ty, float b, Timestamp t) {
        accountName = name;
        userName = user;
        type = ty;
        balance = b;
        updated = t;
    }
    
}
