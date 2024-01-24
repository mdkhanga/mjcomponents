package com.heavyduty.services.controller;

import com.heavyduty.services.api.User;
import com.heavyduty.services.entities.UsersEntity;
import com.heavyduty.services.repository.JDBCUsersRepository;
import com.heavyduty.services.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

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

    public ResponseEntity<String> signin(@RequestBody User u) {

        try {
            UsersEntity ue = usersRepository.findById(u.getUsername()).get();

            if (ue.getPassword().equals(u.getPassword())) {
                return ResponseEntity.ok("success");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid Password !");
            }
        } catch(NoSuchElementException n) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }

    }

}
