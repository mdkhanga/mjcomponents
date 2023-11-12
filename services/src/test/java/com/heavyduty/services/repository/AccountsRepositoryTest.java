package com.heavyduty.services.repository;

import com.heavyduty.services.entities.AccountId;
import com.heavyduty.services.entities.AccountsEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AccountsRepositoryTest {

    @Autowired
    AccountsRepository accountsRepository;

    @Test
    public void testone() {

        accountsRepository.save(new AccountsEntity(new AccountId("manoj","BOAChecking"),"checking",123.45F));
        Optional<AccountsEntity> res = accountsRepository.findById(new AccountId("manoj","BOAChecking"));
        assertTrue(res.isPresent());
        assertEquals("BOAChecking",res.get().getAccountId().getAccountName());
        assertEquals(123.45F,res.get().getBalance());
        accountsRepository.deleteById(new AccountId("manoj","BOAChecking"));
    }

    @Test
    public void testMany() {

        Set<String> accounts = Set.of("BOAChecking", "CitiChecking", "EtradeBrokerage", "VanguardBrokerage") ;

        accountsRepository.save(new AccountsEntity(new AccountId("manoj","BOAChecking"),"checking",123.45F));
        accountsRepository.save(new AccountsEntity(new AccountId("manoj","CitiChecking"),"checking",241.45F));
        accountsRepository.save(new AccountsEntity(new AccountId("manoj","EtradeBrokerage"),"broker",291.45F));
        accountsRepository.save(new AccountsEntity(new AccountId("manoj","VanguardBrokerage"),"broker",292.45F));

        Iterable<AccountsEntity> res = accountsRepository.findAll();

        res.forEach((c)->{
            assertTrue(accounts.contains(c.getAccountId().getAccountName()));
        });

        accountsRepository.deleteById(new AccountId("manoj","BOAChecking"));
        accountsRepository.deleteById(new AccountId("manoj","CitiChecking"));
        accountsRepository.deleteById(new AccountId("manoj","EtradeBrokerage"));
        accountsRepository.deleteById(new AccountId("manoj","VanguardBrokerage"));

    }
}