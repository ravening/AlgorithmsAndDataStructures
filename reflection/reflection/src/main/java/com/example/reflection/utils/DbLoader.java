package com.example.reflection.utils;

import com.example.reflection.models.Person;
import com.example.reflection.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DbLoader implements CommandLineRunner {
    @Autowired
    PersonRepository personRepository;

    @Override
    public void run(String... args) throws Exception {
        // Person john = Person.builder()
        //         .firstName("John")
        //         .lastName("Doe")
        //         .age(20).build();

        // Person sam = Person.builder()
        //         .firstName("Samantha")
        //         .lastName("Woods")
        //         .age(30).build();

        // Person sarah = Person.builder()
        //         .firstName("Sarah")
        //         .lastName("Drasner")
        //         .age(25).build();


        // List<Person> personList = List.of(john, sam, sarah);
        // personRepository.saveAll(personList);
    }
}
