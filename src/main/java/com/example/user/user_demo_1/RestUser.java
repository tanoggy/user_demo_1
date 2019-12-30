package com.example.user.user_demo_1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping("/api/v1")
public class RestUser {


    private UserRepository userRepository;

    public RestUser(ApplicationContext context) {
        userRepository  =  context.getBean(UserRepository.class);
    }



    @GetMapping("/user")
    public List<User> getUserList()
    {
        return userRepository.findAll();
    }


    @PostMapping("/user")
    public ResponseEntity addUser(@RequestBody User user)
    {

        if (userRepository.existsById(user.getEmail()))
        {
            return ResponseEntity.ok().body(user.getEmail() + " duplicate");
        }
        userRepository.save(user);
        return ResponseEntity.ok().body(user);
    }


    @PutMapping("/user")
    public ResponseEntity editUser(@RequestBody User user)
    {
        if (!userRepository.existsById(user.getEmail()))
        {
            return ResponseEntity.ok().body(user.getEmail() + " not found");
        }

        User dbUser = userRepository.getOne(user.getEmail());

        dbUser.setPassword(user.getPassword());

        userRepository.save(dbUser);
        return  ResponseEntity.ok().body(user);

    }

    @DeleteMapping("/user")
    public ResponseEntity deleteUser(@RequestBody User user)
    {
        if (!userRepository.existsById(user.getEmail()))
        {
            return ResponseEntity.ok().body(user.getEmail() + " not found");
        }

        userRepository.deleteById(user.getEmail());
        return  ResponseEntity.ok().body(user);

    }









}
