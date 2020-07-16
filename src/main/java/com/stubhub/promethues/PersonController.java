package com.stubhub.promethues;

import org.springframework.metrics.annotation.Timed;
import org.springframework.metrics.instrument.MeterRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@Timed
class PersonController {
    Map<Integer, Person> people = new HashMap<>();

    public PersonController(MeterRegistry registry) {
        // constructs a gauge to monitor the size of the population
        registry.mapSize(people,"population");
    }


    @GetMapping("/api/people")
    public List<Person> listPeople() {

        List<Person> persons = new ArrayList<>();
        for(Person p: people.values()){
            persons.add(p);
        }

        return persons;
    }

    @GetMapping("/api/person/")
    public Person findPerson(@PathVariable Integer id) {
        return people.get(id);
    }
}