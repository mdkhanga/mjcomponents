package com.heavyduty.services.api;

public record MonthBalance(int id,
                           int accountid ,
                           int month,
                           int year,
                           float balance) {}
