package com.altindag.hobbyproject.controller;

import com.altindag.hobbyproject.dto.PersonDto;
import com.altindag.hobbyproject.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<PersonDto> getPeople() {
        return personService.getPeople();
    }

    @PostMapping("/addPerson")
    public void addPerson(@RequestBody PersonDto personDto) {
        personService.addPerson(personDto);
    }

    @DeleteMapping("/deletePerson/{id}")
    public void deletePerson(@PathVariable String id) {
        personService.deletePerson(id);
    }

    @PutMapping("/updatePerson/{id}")
    public ResponseEntity<PersonDto> updatePerson(
            @PathVariable String id,
            @RequestBody PersonDto dto) {
        PersonDto updatedPerson = personService.updatePerson(id, dto);
        return ResponseEntity.ok(updatedPerson);
    }
}
