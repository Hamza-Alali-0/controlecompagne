package org.example.charityproject1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "org.example.charityproject1.repository")
public class Charityproject1Application {

    public static void main(String[] args) {
        SpringApplication.run(Charityproject1Application.class, args);
    }

}
