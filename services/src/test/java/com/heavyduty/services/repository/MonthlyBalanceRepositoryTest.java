package com.heavyduty.services.repository;

import com.heavyduty.services.api.MonthBalance;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MonthlyBalanceRepositoryTest {

    @Autowired
    private MonthlyBalanceRepository monthlyBalanceRepository ;

    @BeforeEach
    public void initTest() {
        monthlyBalanceRepository.delete("manoj");
    }

    @Test
    public void testInsert() {

        monthlyBalanceRepository.insert("manoj", new MonthBalance(1,1,1,2024 ,3000));

    }

    @Test
    public void testget() {

        monthlyBalanceRepository.insert("manoj", new MonthBalance(1,1,1,2024 ,3000));
        monthlyBalanceRepository.insert("manoj", new MonthBalance(1,1,2,2024 ,3145));

        List<MonthBalance> ret = monthlyBalanceRepository.getMonthlyBalances("manoj",2024);

        assertEquals(2, ret.size());
        assertEquals(3000, ret.get(0).balance());
        assertEquals(3145, ret.get(1).balance());

    }

}