package com.altindag.hobbyproject.repository;

import com.altindag.hobbyproject.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
