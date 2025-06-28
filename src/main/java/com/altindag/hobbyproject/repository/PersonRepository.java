package com.altindag.hobbyproject.repository;

import com.altindag.hobbyproject.domain.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person, String> {
}
