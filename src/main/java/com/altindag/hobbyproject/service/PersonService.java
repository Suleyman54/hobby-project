package com.altindag.hobbyproject.service;

import com.altindag.hobbyproject.domain.Person;
import com.altindag.hobbyproject.dto.PersonDto;
import com.altindag.hobbyproject.mapper.PersonMapper;
import com.altindag.hobbyproject.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    public PersonService(PersonRepository personRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    public List<PersonDto> getPeople() {
        return personRepository.findAll().stream()
                .map(personMapper::mapToPersonDto)
                .toList();
    }

    public PersonDto addPerson(PersonDto personDto) {
        Person person = personMapper.mapToPerson(personDto);
        person = personRepository.save(person);
        return personMapper.mapToPersonDto(person);
    }

    public void deletePerson(String id) {
        if (!personRepository.existsById(id)) {
            throw new IllegalStateException(String
                    .format("Person with id: %s does not exists", id));
        }
        personRepository.deleteById(id);
    }

    public PersonDto updatePerson(String id, PersonDto dto) {
        Person existingPerson = personRepository
                .findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        String.format("Person with id: %s does not exist", id)));
        existingPerson.setName(dto.getName());
        existingPerson.setAge(dto.getAge());
        existingPerson.setBalance(dto.getBalance());
        return personMapper.mapToPersonDto(personRepository.save(existingPerson));
    }
}
