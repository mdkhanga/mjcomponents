package com.heavyduty.services.repository;

import com.heavyduty.services.api.Operation;
import com.heavyduty.services.entities.AccountId;
import com.heavyduty.services.entities.AccountsEntity;
import com.heavyduty.services.entities.TransactionsEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TransactionsRepositoryTest {

    @Autowired
    TransactionsRepository transactionsRepository;

    @Autowired
    AccountsRepository accountsRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    public void testOne() {

        TransactionsEntity te = transactionsRepository.save(new TransactionsEntity(new AccountId("manoj","BOAChecking"), 100, Operation.CREDIT));

        System.out.println(te.getTransactionId());

    }

}