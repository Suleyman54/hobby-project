package com.altindag.hobbyproject.service;

import com.altindag.hobbyproject.domain.Person;
import com.altindag.hobbyproject.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
        Optional<Person> idOptional = personRepository.findById(person.getId());
        if (idOptional.isPresent()){
            throw new IllegalStateException("id taken");
        }
        personRepository.save(person);
    }

    public void deletePerson(Long id){
        boolean present = personRepository.existsById(id);
        if(!present){
            throw new IllegalStateException(String.format("Person with id: %s does not exists", id));
        }
        personRepository.deleteById(id);
    }

    public void updatePerson(Person person){
        int idx = 0;
        Long id = 0L;

        for (int i =0; i<people.size(); i++){
            if (people.get((i)).getId().equals(person.getId())){
                id = person.getId();
                idx = i;
                break;
            }
        }
        Person person1 = new Person();
        person1.setId(id);
        person1.setName(person.getName());
        person1.setAge(person.getAge());
        person1.setBalance(person.getBalance());

        people.set(idx, person1);
    }
}
