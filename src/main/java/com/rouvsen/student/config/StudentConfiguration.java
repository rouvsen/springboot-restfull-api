package com.rouvsen.student.config;

import com.rouvsen.student.dal.StudentRepository;
import com.rouvsen.student.model.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.DECEMBER;

@Configuration
public class StudentConfiguration {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student alex = new Student(
                    "Alex",
                    "alex@gmail.com",
                    LocalDate.of(2000, DECEMBER, 5)
            );
            Student mariam = new Student(
                    "Mariam",
                    "mariam@gmail.com",
                    LocalDate.of(2006, DECEMBER, 11)
            );
            repository.saveAll(
                    List.of(alex, mariam)
            );
        };
    }
}
