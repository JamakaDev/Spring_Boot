package com.example.demo.student;

import static java.time.Month.APRIL;
import static java.time.Month.JANUARY;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
    
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student jon = new Student(
                "Jon",
                "jon@email.com",
                LocalDate.of(1988, APRIL, 10)
            );
            
            Student kayla = new Student(
                "kayla",
                "kayla@email.com",
                LocalDate.of(1991, JANUARY, 31)
            );

            repository.saveAll(
                List.of(jon, kayla)
            );
        };
    }
}
