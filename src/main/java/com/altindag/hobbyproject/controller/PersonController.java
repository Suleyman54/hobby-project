package com.altindag.hobbyproject.controller;

import com.altindag.hobbyproject.domain.Person;
import com.altindag.hobbyproject.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/person")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService){
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getPeople(){
        return personService.getPeople();
    }

    @PostMapping("/addPerson")
    public void addPerson(@RequestBody Person person){
        personService.addPerson(person);
    }

    @DeleteMapping("/deletePerson/{id}")
    public void deletePerson(@PathVariable Long id){
        personService.deletePerson(id);
    }

    @PutMapping("/updatePerson/{id}")
    public void updatePerson(
            @PathVariable Long id,
            @RequestParam(required = false) Long balance){
        personService.updatePerson(id, balance);
    }
}
