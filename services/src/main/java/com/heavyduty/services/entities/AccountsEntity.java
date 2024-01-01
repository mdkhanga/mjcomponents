package com.heavyduty.services.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Calendar;

@Entity
@Table(name = "accounts")
public class AccountsEntity {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "accountname")
    private String accountName;

    @Column(name = "id")
    private String userName;


    @Column(name = "type")
    private String type;

    @Column(name = "balance")
    private float balance;

    @Column(name = "updated")
    private Timestamp updated  ;

    public AccountsEntity() {

    }

    public AccountsEntity(AccountId a, String t, float f) {
        accountId = a ;
        type = t ;
        balance = f;
        Calendar c = Calendar.getInstance();
        updated = new Timestamp(c.getTime().getTime());
    }

    public AccountId getAccountId() {
        return accountId;
    }

    public void setAccountId(AccountId s) {
        accountId = s;
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
