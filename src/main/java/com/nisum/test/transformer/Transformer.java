package com.nisum.test.transformer;

import com.nisum.test.dto.PersonDto;
import com.nisum.test.entity.Person;

public class Transformer {

    public PersonDto transformFromPersonToPersonDto(Person person){
        return PersonDto.builder()
                .id(person.getId())
                .created(person.getCreated())
                .modified(person.getModified())
                .deleted(person.getDeleted())
                .lastLogin(person.getLastLogin())
                .isActive(person.isActive())
                .token(person.getToken())
                .name(person.getName())
                .email(person.getEmail())
                .password(person.getPassword())
                .phoneNumbers(person.getPhones())
                .build();
    }

    public Person transformFromPersonDtoToPerson(PersonDto personDto){
        return Person.builder()
                .id(personDto.getId())
                .created(personDto.getCreated())
                .modified(personDto.getModified())
                .deleted(personDto.getDeleted())
                .lastLogin(personDto.getLastLogin())
                .isActive(personDto.isActive())
                .token(personDto.getToken())
                .name(personDto.getName())
                .email(personDto.getEmail())
                .password(personDto.getPassword())
                .phones(personDto.getPhoneNumbers())
                .build();
    }
}
