package com.altindag.hobbyproject.service;

import com.altindag.hobbyproject.domain.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private List<Person> people;

    public PersonService(List<Person> people) {
        this.people = people;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public void deletePerson(Long id){
        people.removeIf(x -> x.getId().equals(id));
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
