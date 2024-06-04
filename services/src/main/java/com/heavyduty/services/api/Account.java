package com.heavyduty.services.api;

public class Account {


    private int id;
    private String name ;
    private AccountType type;
    private float balance;

    public Account(int i, String n, AccountType t, float b) {
        id = i;
        name = n ;
        type = t ;
        balance = b;
    }

    public int getId() {
        return id;
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

    public String toString() {
        return String.format("%s %s %f",name, type, balance);
    }
}
