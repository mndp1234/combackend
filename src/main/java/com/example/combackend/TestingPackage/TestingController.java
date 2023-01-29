package com.example.combackend.TestingPackage;

import com.example.combackend.User;
import com.example.combackend.UserRepository;
import com.example.combackend.kafka.KafkaProducer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestingController {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private KafkaProducer kafkaProducer;

    private final RedisTemplate<String,String> redisTemplate;

    public static final Logger log = LogManager.getLogger(TestingController.class);


    public TestingController(RedisTemplate<String,String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }


    @GetMapping("/test/api")
    public String TestApi(@RequestParam String name){
        log.info("api is called");
        User user = new User();
        user.setName(name);
        userRepository.save(user);

        redisTemplate.opsForValue().set("testing",name);


        log.info("Api gives the error");

        kafkaProducer.sendMessage("test",name);



        return redisTemplate.opsForValue().get("testing");
    }

}
