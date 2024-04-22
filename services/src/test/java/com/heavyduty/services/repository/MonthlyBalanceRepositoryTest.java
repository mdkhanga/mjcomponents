package com.heavyduty.services.repository;

import com.heavyduty.services.api.Account;
import com.heavyduty.services.api.MonthBalance;
import com.heavyduty.services.entities.AccountsEntity;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
class MonthlyBalanceRepositoryTest {

    @Autowired
    private MonthlyBalanceRepository monthlyBalanceRepository ;

    @Autowired
    private AccountsRepository accountsRepository;

    private AccountsEntity accountsEntity;


    @BeforeAll
    public void beforell() {
        accountsEntity = accountsRepository.save(new AccountsEntity("manoj","BOAChecking","checking",123.45F));
    }

    @AfterAll
    public void afterll() {
        monthlyBalanceRepository.delete("manoj");
        accountsRepository.deleteAll();
    }

    @BeforeEach
    public void initTest() {
        monthlyBalanceRepository.delete("manoj");
    }

    @Test
    public void testInsert() {

        monthlyBalanceRepository.insert("manoj", new MonthBalance(1,accountsEntity.getId(),1,2024 ,3000));

    }

    @Test
    public void testget() {

        monthlyBalanceRepository.insert("manoj", new MonthBalance(1,accountsEntity.getId(),1,2024 ,3000));
        monthlyBalanceRepository.insert("manoj", new MonthBalance(1,accountsEntity.getId(),2,2024 ,3145));

        List<MonthBalance> ret = monthlyBalanceRepository.getMonthlyBalances("manoj",2024);

        assertEquals(2, ret.size());
        assertEquals(3000, ret.get(0).balance());
        assertEquals(3145, ret.get(1).balance());

    }

}