package com.example.user.user_demo_1;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@RequiredArgsConstructor
public class UserDemo1Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(UserDemo1Application.class, args);



    }

}
