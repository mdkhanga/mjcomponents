package com.heavyduty.services.controller;

import com.heavyduty.services.api.Account;
import com.heavyduty.services.api.AccountTransaction;
import com.heavyduty.services.api.AccountType;
import com.heavyduty.services.entities.AccountId;
import com.heavyduty.services.entities.AccountsEntity;
import com.heavyduty.services.repository.AccountsJDBCRepository;
import com.heavyduty.services.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/accounts")
@CrossOrigin
public class AccountsController {

    @Autowired
    AccountsRepository accountsRepository;

    @Autowired
    AccountsJDBCRepository accountsJDBCRepository;

    private static int i = 0;

    public AccountsController() {

    }

    @GetMapping("/{username}")
    public List<Account> getAccounts(@PathVariable("username") String username) {
        System.out.println("Received request" + ++i + " " + username);
        List<Account> ret = new ArrayList<>();
        Iterable<AccountsEntity> entities = accountsRepository.findAllByUserName(username);

        entities.forEach((c)->{
            ret.add(new Account(c.getId(), c.getAccountName(), AccountType.valueOf(c.getType()), c.getBalance()));
            System.out.println(c.getAccountName());
        });

        return ret;
    }

    @GetMapping("/names/{username}")
    public List<String> getAccountNames(@PathVariable("username") String username) {
        return accountsJDBCRepository.getAccountNames(username);
    }

    @GetMapping("/user/{id}")
    public Account getAccount(@PathVariable("id") int id) {

        AccountsEntity accountEntity = accountsRepository.findById(id).get();

        return new Account(accountEntity.getId(), accountEntity.getAccountName(), AccountType.valueOf(accountEntity.getType()), accountEntity.getBalance());
    }

    @PostMapping("/{username}")
    public void createAccount(@RequestBody Account a, @PathVariable("username") String username) {

        System.out.print(a);
        accountsRepository.save(new AccountsEntity(username,a.getName()
                    ,a.getType().toString() ,a.getBalance()));

    }

    @PutMapping
    public void updateAccount(@RequestBody Account a) {

        accountsRepository.save(new AccountsEntity("manoj",a.getName()
                ,a.getType().toString() ,a.getBalance()));

    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable("id") int id) {
        accountsRepository.deleteById(id);
    }

    @Transactional
    // @PostMapping
    public void addDebitCredit(@RequestBody AccountTransaction at) {

    }

}
