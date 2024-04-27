package com.heavyduty.services.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountsJDBCRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate ;

    public List<String> getAccountNames(String username) {
        String sql = "SELECT accountname FROM accounts WHERE username = ? ORDER BY accountname";
        return jdbcTemplate.queryForList(sql, String.class, username);

    }
}
