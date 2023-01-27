package com.example.combackend.TestingPackage;

import com.example.combackend.User;
import com.example.combackend.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestingController {


    @Autowired
    private UserRepository userRepository;

    @GetMapping("/test/api")
    public String TestApi(@RequestParam String name){
        System.out.println("system is running ");
        User user = new User();
        user.setName(name);
        userRepository.save(user);

        return "success";
    }

}
