package com.heavyduty.services.controller;

import com.heavyduty.services.api.Account;
import com.heavyduty.services.api.AccountTransaction;
import com.heavyduty.services.api.AccountType;
import com.heavyduty.services.entities.AccountId;
import com.heavyduty.services.entities.AccountsEntity;
import com.heavyduty.services.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/accounts")
@CrossOrigin
public class AccountsController {

    @Autowired
    AccountsRepository accountsRepository;

    public AccountsController() {

    }

    @GetMapping("/{username}")
    public List<Account> getAccounts(@PathParam("username") String username) {
        List<Account> ret = new ArrayList<>();
        Iterable<AccountsEntity> entities = accountsRepository.findAll();

        entities.forEach((c)->{
            ret.add(new Account(c.getAccountId().getAccountName(), AccountType.valueOf(c.getType()), c.getBalance()));
        });

        return ret;
    }

    @GetMapping("/{username}/{account}")
    public Account getAccount(@PathVariable("username") String username, @PathVariable("account") String account) {

        AccountsEntity accountEntity = accountsRepository.findById(new AccountId(username, account)).get();

        return new Account(accountEntity.getAccountId().getAccountName(), AccountType.valueOf(accountEntity.getType()), accountEntity.getBalance());
    }

    @PostMapping
    public void createAccount(@RequestBody Account a) {

        accountsRepository.save(new AccountsEntity(new AccountId("manoj",a.getName())
                    ,a.getType().toString() ,a.getBalance()));

    }

    @PutMapping
    public void updateAccount(@RequestBody Account a) {

        accountsRepository.save(new AccountsEntity(new AccountId("manoj",a.getName())
                ,a.getType().toString() ,a.getBalance()));

    }

    @DeleteMapping("/{username}/{account}")
    public void deleteAccount(@PathVariable("username") String username, @PathVariable("account") String account) {
        accountsRepository.deleteById(new AccountId(username, account));
    }

    @Transactional
    // @PostMapping
    public void addDebitCredit(@RequestBody AccountTransaction at) {

    }

}
