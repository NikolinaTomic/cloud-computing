package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/controller")
public class Controller {

    @Autowired

    public Repository counterRepository;
    @GetMapping("init")
    public ResponseEntity<String> init(){
        Counter counter = new Counter();
        counter.setCount(0);
        counterRepository.save(counter);
        return ResponseEntity.ok(String.format("Success"));
    }

    @GetMapping("count")
    public ResponseEntity<String> count(){
        String pass = System.getenv("password");
        String user = System.getenv("user");
        String host = System.getenv("host");
        Counter counter = (Counter) counterRepository.getOne(1l);
        counter.setCount(counter.getCount()+1);
        counterRepository.save(counter);
        return ResponseEntity.ok(String.format("Host:" + host +", User:" + user + ", Password: " + pass + ", Counter: " + counter.getCount()+" "));
    }
}
