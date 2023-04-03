package com.heavyduty.services.controller;

import com.heavyduty.services.api.User;
import com.heavyduty.services.entities.UsersEntity;
import com.heavyduty.services.repository.JDBCUsersRepository;
import com.heavyduty.services.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @Autowired
    private UsersRepository usersRepository;


    @GetMapping("/about")
    public String about() {

        UsersEntity u = new UsersEntity("manoj","manoj12", "manoj@email.com");
        usersRepository.save(u);

        return "Greetings from the user controller";
    }

    @GetMapping("/users")
    public List<User> getUsers() {

        System.out.println("mmmjjjjj...... Using spring data repository");

        List<User> users = new ArrayList<>();
        // UsersEntity u = usersRepository.findById("manoj").get();
        Iterable<UsersEntity> iu = usersRepository.findAll();

        // users.add(new User(u.getUsername(),u.getPassword(), u.getEmail()));
        iu.forEach(ue -> {
            users.add(new User(ue.getUsername(),ue.getPassword(), ue.getEmail()));
        });
        return users;
    }

    @PostMapping("/users")
    public void createUser(@RequestBody User u) {
        usersRepository.save(new UsersEntity(u.getUsername(),u.getPassword(),u.getEmail()));
    }

}
