package com.heavyduty.services.api;

public record MonthBalance(int id,
                           int accountid,
                           String accountname ,
                           int month,
                           int year,
                           float balance) {}
