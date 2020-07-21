package com.stubhub.promethues;

import org.springframework.metrics.annotation.Timed;
import org.springframework.metrics.instrument.MeterRegistry;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/api/person/{id}")
    public Person findPerson(@PathVariable Integer id) {
        return people.get(id);
    }


    @PostMapping("/api/person")
    public String addPerson(@RequestBody Person person) {
        Integer Key = person.getId().intValue();
        if(people.get(Key)!=null){
            throw new RuntimeException("Person exist already");
        }
        if(Key==0){
            people.clear();
            return "Add Person Successfully";
        }
        people.put(person.getId().intValue(),person);
        return "Add Person Successfully";
    }

    @GetMapping("/error/test")
    public String exceptionApi() {
        throw new RuntimeException("Error Test");
    }

    @GetMapping("/api/clear")
    public String clear(){

        try {
            Thread.sleep(1000);
        }catch (Exception e){

        }
        people.clear();
        return "Clear map successfully";
    }
}