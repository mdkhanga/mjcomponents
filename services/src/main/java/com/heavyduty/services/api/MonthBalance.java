package com.heavyduty.services.api;

public record MonthBalance(String username,
                           int account,
                           int month,
                           int year,
                           float balance) {}
