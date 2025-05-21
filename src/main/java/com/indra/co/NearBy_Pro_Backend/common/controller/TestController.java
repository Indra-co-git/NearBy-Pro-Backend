package com.indra.co.NearBy_Pro_Backend.common.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/test")
public class TestController {

    @GetMapping("/cors")
    public String testCors() {
        return "CORS is working!";
    }

    @PostMapping("/cors")
    public String testCorsPost(@RequestBody String body) {
        return "Received: " + body;
    }
} 