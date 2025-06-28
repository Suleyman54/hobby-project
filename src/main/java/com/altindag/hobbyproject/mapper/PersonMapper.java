package com.altindag.hobbyproject.mapper;

import com.altindag.hobbyproject.domain.Person;
import com.altindag.hobbyproject.dto.PersonDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonDto mapToPersonDto(Person person);
    Person mapToPerson(PersonDto personDto);
}
