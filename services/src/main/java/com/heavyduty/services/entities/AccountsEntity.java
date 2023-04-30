package com.heavyduty.services.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "accounts")
public class AccountsEntity {

    @Id
    @Column(name = "accountname")
    private String accountName;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username")
    @Column(name = "username")
    private UsersEntity user;

    private String type;
    private float balance;
    private Timestamp updated;

    public AccountsEntity() {

    }

    private String getAccountName() {
        return accountName;
    }

    private void setAccountName(String s) {
        accountName = s;
    }




}
