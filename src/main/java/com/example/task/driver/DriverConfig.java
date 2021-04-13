package com.example.task.driver;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalTime;
import java.util.List;

@Configuration
public class DriverConfig {

    @Bean
    CommandLineRunner commandLineRunner(DriverRepository repository) {
        return args -> {
            Driver igor = new Driver(
             "Igor",
             "Moscow",
             25,
             true,
                    LocalTime.of(9, 0),
                    LocalTime.of(19, 0),
             "45.16-83.17"
            );
            Driver alex = new Driver(
                    "Alex",
                    "Tel-Aviv",
                    31,
                    false,
                    LocalTime.of(23,30),
                    LocalTime.of(8, 0),
                    "25.67-43.77"
            );

            repository.saveAll(List.of(igor, alex));
        };
    }
}
