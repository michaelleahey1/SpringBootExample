package com.ust.SpringBootExample.api;

import com.ust.SpringBootExample.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ust.SpringBootExample.service.PersonService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/person")
public class PersonController {
    private final PersonService personService;
    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    @PostMapping
    public void addPerson() {
        personService.addPerson( new Person( UUID.randomUUID(), "bob"));
        personService.addPerson( new Person( UUID.randomUUID(), "sue"));
        personService.addPerson( new Person( UUID.randomUUID(), "jill"));
    }
    @GetMapping
    public List<Person> getAllPeople() {
        return personService.selectAllPeople();
    }
}