package com.ust.SpringBootExample.api;

import com.ust.SpringBootExample.model.Person;
import com.ust.SpringBootExample.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value="api/v1/person")
public class PersonController {
    private final PersonService personService;
    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping( value= "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addPerson( @RequestBody Person person) {
        personService.addPerson( person);
    }
    @GetMapping
    public List<Person> getAllPeople() {
        return personService.selectAllPeople();
    }
    //localhost:8080/api/v1/person/4f08d993-e612-470f-ae66-857ca35a1804
    @GetMapping( value="/{id}")
    public Person getPerson( @PathVariable("id") UUID id) {
        return personService.getPersonById(id).orElse(null);
    }
    @DeleteMapping( value="/{id}")
    public int deletePerson( @PathVariable("id") UUID id) {
        return personService.deletePerson(id);
    }
    @PutMapping( value="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public int updatePerson( @PathVariable("id") UUID id, @RequestBody Person person) {
        return personService.updatePerson(id, person);
    }
}