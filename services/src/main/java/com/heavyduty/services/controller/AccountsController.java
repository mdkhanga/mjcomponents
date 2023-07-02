package com.heavyduty.services.controller;

import com.heavyduty.services.api.Account;
import com.heavyduty.services.api.AccountType;
import com.heavyduty.services.entities.AccountId;
import com.heavyduty.services.entities.AccountsEntity;
import com.heavyduty.services.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/accounts")
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
    public Account getAccount(@PathParam("username") String username, @PathParam("account") String account) {

        AccountsEntity accountEntity = accountsRepository.findById(new AccountId(username, account)).get();

        return new Account(accountEntity.getAccountId().getAccountName(), AccountType.valueOf(accountEntity.getType()), accountEntity.getBalance());
    }
}
