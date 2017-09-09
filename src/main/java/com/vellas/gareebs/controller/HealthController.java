package com.vellas.gareebs.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class HealthController {
    @RequestMapping("/health")
    public ResponseEntity ok() {
        HashMap<String, String> map = new HashMap<>();
        map.put("status", "OK");
        return new ResponseEntity(map, HttpStatus.OK);
    }
}
