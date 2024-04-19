package com.heavyduty.services.api;

public record MonthBalance(int id,
                            String accountname,
                           int month,
                           int year,
                           float balance) {}
