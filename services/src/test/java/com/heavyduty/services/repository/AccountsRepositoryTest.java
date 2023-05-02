package com.heavyduty.services.repository;

import com.heavyduty.services.entities.AccountsEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Optional;

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

}