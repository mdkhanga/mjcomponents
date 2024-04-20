package com.heavyduty.services.repository;

import com.heavyduty.services.api.MonthBalance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MonthlyBalanceRepository {

    @Autowired
    private NamedParameterJdbcTemplate namedJdbcTemplate ;

    List<MonthBalance> getMonthlyBalances(String username, int year) {

        // List<MonthBalance> ret = new ArrayList<>();

        String sql = "SELECT a.id, a.accountname, mb.bmonth, mb.byear, mb.balance " +
                "FROM monthlybalance mb " +
                "INNER JOIN accounts a ON mb.accountid = a.id and mb.username = a.username " +
                "WHERE mb.byear = :year and mb.username = :username" ;

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("year", year);
        params.addValue("username", username) ;

        return namedJdbcTemplate.query(sql, params, new MonthBalanceMapper());



    }

    private static class MonthBalanceMapper implements RowMapper<MonthBalance> {
        @Override
        public MonthBalance mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new MonthBalance(
                    rs.getInt("id"),
                    rs.getString("accountname"),
                    rs.getInt("bmonth"),
                    rs.getInt("byear"),
                    rs.getFloat("balance")
            );
        }
    }


}
