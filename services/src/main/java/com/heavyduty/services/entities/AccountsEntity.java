package com.heavyduty.services.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "accounts")
public class AccountsEntity {

    @Id
    @Column(name = "accountname")
    private String accountName;

    // @OneToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "username")
    @Column(name = "username")
    private String userName;

    @Column(name = "type")
    private String type;

    @Column(name = "balance")
    private float balance;

    @Column(name = "updated")
    private Timestamp updated;

    public AccountsEntity() {

    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String s) {
        accountName = s;
    }

    private String getUserName() {
        return userName;
    }

    private void setUserName(String s) {
        userName = s;
    }



}
