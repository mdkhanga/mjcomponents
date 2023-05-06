package com.heavyduty.services.repository;

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

        accountsRepository.save(new AccountsEntity("BOAChecking","manoj","checking",123.45F));
        Optional<AccountsEntity> res = accountsRepository.findById("BOAChecking");
        assertTrue(res.isPresent());
        assertEquals("BOAChecking",res.get().getAccountName());
        assertEquals(123.45F,res.get().getBalance());
        accountsRepository.deleteById("BOAChecking");
    }

    @Test
    public void testMany() {

        Set<String> accounts = Set.of("BOAChecking", "CitiChecking", "EtradeBrokerage", "VanguardBrokerage") ;

        accountsRepository.save(new AccountsEntity("BOAChecking","manoj","checking",123.45F));
        accountsRepository.save(new AccountsEntity("CitiChecking","manoj","checking",241.45F));
        accountsRepository.save(new AccountsEntity("EtradeBrokerage","manoj","broker",291.45F));
        accountsRepository.save(new AccountsEntity("VanguardBrokerage","manoj","broker",292.45F));

        Iterable<AccountsEntity> res = accountsRepository.findAll();

        res.forEach((c)->{
            assertTrue(accounts.contains(c.getAccountName()));
        });

        accountsRepository.deleteById("BOAChecking");
        accountsRepository.deleteById("CitiChecking");
        accountsRepository.deleteById("EtradeBrokerage");
        accountsRepository.deleteById("VanguardBrokerage");

    }
}