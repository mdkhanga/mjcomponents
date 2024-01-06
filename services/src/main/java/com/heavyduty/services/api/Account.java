package com.heavyduty.services.api;

public class Account {

    
    private String name ;
    private AccountType type;
    private float balance;

    public Account(String n, AccountType t, float b) {
        name = n ;
        type = t ;
        balance = b;
    }

    public String getName() {
        return name;
    }

    public AccountType getType() {
        return type;
    }

    public float getBalance() {
        return balance;
    }
}
