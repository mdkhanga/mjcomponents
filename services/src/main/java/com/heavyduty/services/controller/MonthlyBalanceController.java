package com.heavyduty.services.controller;

import com.heavyduty.services.api.Account;
import com.heavyduty.services.api.MonthBalance;
import com.heavyduty.services.repository.MonthlyBalanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/mbalances")
@CrossOrigin
public class MonthlyBalanceController {

    @Autowired
    MonthlyBalanceRepository monthlyBalanceRepository;


    /* @GetMapping("/{username}/{year}")
    public List<MonthBalance> getMonthlyBalances(@PathVariable("username") String username,
                                                 @PathVariable("year") int year) {

        return monthlyBalanceRepository.getMonthlyBalances(username, year);
    } */

    @GetMapping("/{username}/{year}")
    public Map<Integer, List<MonthBalance>> getMonthlyBalances(@PathVariable("username") String username,
                                                        @PathVariable("year") int year) {

        // Key = month, List of account balances for month sorted by id

        Map<Integer, List<MonthBalance>> ret = new HashMap<>();
        List<MonthBalance> bals = monthlyBalanceRepository.getMonthlyBalances(username, year);

        bals.forEach((b) -> {

            List<MonthBalance> mlist = ret.get(b.month()) ;
            if (mlist == null) {
                mlist = new ArrayList<>();
                ret.put(b.month(), mlist);
            }

           mlist.add(b) ;
        });

        ret.forEach((k,v) -> {
            v.sort(Comparator.comparingInt(MonthBalance::accountid));
        }) ;

        return ret ;
    }

    @PostMapping("/{username}")
    public void createMonthlyBalances(@PathVariable("username") String username, @RequestBody List<MonthBalance> balances) {


        balances.forEach((m) -> {
            System.out.println(m.accountname() + " " + m.balance());
            monthlyBalanceRepository.insert(username, m);
        });

    }
}
