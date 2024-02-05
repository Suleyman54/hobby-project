package com.altindag.hobbyproject.service;

import com.altindag.hobbyproject.domain.Person;
import com.altindag.hobbyproject.repository.PersonRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PersonService {

    private List<Person> people;

    @Autowired
    PersonRepository personRepository;

    public PersonService(List<Person> people) {
        this.people = people;
    }

    public List<Person> getPeople() {
        return personRepository.findAll();
    }

    public void addPerson(Person person) {
        personRepository.save(person);
    }

    public void deletePerson(Long id){
        boolean present = personRepository.existsById(id);
        if(!present){
            throw new IllegalStateException(String.format("Person with id: %s does not exists", id));
        }
        personRepository.deleteById(id);
    }
    @Transactional
    public void updatePerson(Long id, Long balance) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        String.format("Person with id: %s does not exist", id)));
        person.setBalance(balance);
        personRepository.save(person);
    }
}
