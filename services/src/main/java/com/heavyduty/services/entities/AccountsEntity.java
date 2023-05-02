package com.heavyduty.services.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Calendar;

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
    private Timestamp updated  ;

    public AccountsEntity() {

    }

    public AccountsEntity(String s, String a, String t, float f) {
        accountName = s;
        userName = a ;
        type = t ;
        balance = f;
        Calendar c = Calendar.getInstance();
        updated = new Timestamp(c.getTime().getTime());


    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String s) {
        accountName = s;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String s) {
        userName = s;
    }

    public void setType(String s) {
        type = s;
    }

    public String getType() {
        return type;
    }

    public void setBalance(float b) {
        balance = b;
    }

    public float getBalance() {
        return balance;
    }

    public void setUpdated(Timestamp t) {
        updated = t ;
    }

    public Timestamp getUpdated() {
        return updated;
    }
}
