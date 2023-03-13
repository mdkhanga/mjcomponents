package com.heavyduty.services.repository;

import com.heavyduty.services.api.User;
import com.heavyduty.services.entities.UsersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JDBCUsersRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Optional<UsersEntity> findById(String id) {
        return jdbcTemplate.queryForObject(
                "select * from users where username = ?",
                new Object[]{id},
                (rs, rowNum) ->
                        Optional.of(new UsersEntity(
                                rs.getString("username"),
                                rs.getString("password"),
                                rs.getString("email")
                        ))
        );
    }

}
