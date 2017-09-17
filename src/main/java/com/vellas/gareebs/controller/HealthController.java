package com.vellas.gareebs.controller;

import com.vellas.gareebs.dao.PersonRepository;
import com.vellas.gareebs.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.HashMap;

@RestController
public class HealthController {

//    @Autowired
//    private PersonRepository personRepository;

    @RequestMapping("/health")
    public ResponseEntity ok() {
        HashMap<Object, String> map = new HashMap<>();
        map.put("status", "OK");
        Person kutta = new Person("kutta", "kuttraya@doberman.com", false);
//        personRepository.save(kutta);
//        return new ResponseEntity(personRepository.findAll(), HttpStatus.OK);
        return new ResponseEntity(map, HttpStatus.OK);

    }
}
