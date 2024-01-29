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

    @Column(name = "username")
    private String userName;

    @Column(name = "accountname")
    private String accountName;

    @Column(name = "type")
    private String type;

    @Column(name = "balance")
    private float balance;

    @Column(name = "updated")
    private Timestamp updated  ;

    public AccountsEntity() {

    }

    public AccountsEntity(String user, String acctName, String t, float f) {
        userName = user  ;
        acctName = accountName;
        type = t ;
        balance = f;
        Calendar c = Calendar.getInstance();
        updated = new Timestamp(c.getTime().getTime());
    }

    public int getId() {
        return id;
    }

    public void setId(int i) {
        id = i;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
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
