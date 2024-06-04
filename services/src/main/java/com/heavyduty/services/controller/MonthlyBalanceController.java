package com.heavyduty.services.controller;

import com.heavyduty.services.api.Account;
import com.heavyduty.services.api.MonthBalance;
import com.heavyduty.services.repository.MonthlyBalanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/mbalances")
@CrossOrigin
public class MonthlyBalanceController {

    @Autowired
    MonthlyBalanceRepository monthlyBalanceRepository;


    @GetMapping("/{username}/{year}")
    public List<MonthBalance> getMonthlyBalances(@PathVariable("username") String username,
                                                 @PathVariable("year") int year) {

        return monthlyBalanceRepository.getMonthlyBalances(username, year);
    }

    @PostMapping("/{username}")
    public void createMonthlyBalances(@PathVariable("username") String username, @RequestBody List<MonthBalance> balances) {

        balances.forEach((m) -> {
            monthlyBalanceRepository.insert(username, m);
        });

    }
}
