package com.nearbypro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = {
    "com.nearbypro.profession.repository",
    "com.nearbypro.user.repository"
})
public class NearByProBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(NearByProBackendApplication.class, args);
    }
} 