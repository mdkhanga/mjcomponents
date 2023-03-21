package com.heavyduty.services.controller;

import com.heavyduty.services.api.User;
import com.heavyduty.services.entities.UsersEntity;
import com.heavyduty.services.repository.JDBCUsersRepository;
import com.heavyduty.services.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v2/user/")
public class UserJDBCController {


    @Autowired
    private JDBCUsersRepository jdbcUsersRepository;

    @GetMapping("/about")
    public String about() {

        UsersEntity u = new UsersEntity("manoj","manoj12", "manoj@email.com");
        // usersRepository.save(u);

        return "Greetings from the user controller";
    }



    @GetMapping("/users")
    public List<User> getJDBCUsers() {

        System.out.println("mj........Using JDBCTemplate") ;

        List<User> users = new ArrayList<>();
        UsersEntity u = jdbcUsersRepository.findById("manoj").get();

        users.add(new User(u.getUsername(),u.getPassword(), u.getEmail()));
        return users;
    }
}
