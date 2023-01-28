package com.example.combackend.TestingPackage;

import com.example.combackend.User;
import com.example.combackend.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestingController {


    @Autowired
    private UserRepository userRepository;

    public static final Logger log = LogManager.getLogger(TestingController.class);

    @GetMapping("/test/api")
    public String TestApi(@RequestParam String name){
        log.info("api is called");
        User user = new User();
        user.setName(name);
        userRepository.save(user);

        log.info("Api gives the error");

        return "success";
    }

}
