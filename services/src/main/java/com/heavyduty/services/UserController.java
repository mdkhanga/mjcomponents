package com.heavyduty.services;

import com.heavyduty.services.entities.UsersEntity;
import com.heavyduty.services.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/about")
    public String about() {

        UsersEntity u = new UsersEntity("manoj","manoj12", "manoj@email.com");
        usersRepository.save(u);

        return "Greetings from the user controller";
    }
}
