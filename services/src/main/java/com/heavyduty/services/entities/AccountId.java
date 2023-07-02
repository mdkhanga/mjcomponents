package com.heavyduty.services.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class AccountId implements Serializable {

    @Column(name = "username")
    private String userName;

    @Column(name = "accountname")
    private String accountName;

    public AccountId() {

    }

    public AccountId(String user, String account) {
        userName = user;
        accountName = account;
    }

    public String getAccountName()  {
        return accountName;
    }

    public void setAccountName(String s) {
        accountName = s ;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String s) {
        userName = s;
    }
}
