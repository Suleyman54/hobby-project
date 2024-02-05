package com.altindag.hobbyproject.service;

import com.altindag.hobbyproject.domain.Person;
import com.altindag.hobbyproject.repository.PersonRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Getter
    private List<Person> people;

    @Autowired
    PersonRepository personRepository;

    public PersonService(List<Person> people) {
        this.people = people;
    }

    public void addPerson(Person person) {
        personRepository.save(person);
    }

    public void deletePerson(Long id){
        personRepository.deleteById(id);
    }

    public void updatePerson(Person person){

        personRepository.findById(person.getId());
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
