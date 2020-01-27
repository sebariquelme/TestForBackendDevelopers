package com.nisum.test.service;

import com.nisum.test.dto.PersonDto;
import com.nisum.test.entity.Person;
import com.nisum.test.repository.PersonRepository;
import com.nisum.test.transformer.Transformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ValidationException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService extends Transformer {

    @Autowired
    private PersonRepository personRepository;

    @Transactional(readOnly = true)
    public List<PersonDto> findAll() {
        List<Person> personList = new ArrayList<>();
        personRepository.findAll().forEach(personList::add);
        List<PersonDto> personDtoList = personList.stream()
                .map(this::transformFromPersonToPersonDto).collect(Collectors.toList());
        return personDtoList;
    }


    @Transactional(readOnly = true)
    public PersonDto findById(Long id) {
        Person person = personRepository.findById(id).orElse(null);
        return transformFromPersonToPersonDto(person);
    }

    @Transactional
    public PersonDto save(PersonDto personDto) {
        if (personRepository.existsByEmail(personDto.getEmail())){
            String msg = "{\"message\":\"User already existed\"}";
            throw new ValidationException(msg);
        }
        personDto.setLastLogin(new Date());
        personRepository.save(transformFromPersonDtoToPerson(personDto));
        return personDto;
    }


    @Transactional
    public void deleteById(Long id) {
        Person person = personRepository.findById(id).orElse(null);
        if (person != null) {
            person.setDeleted(new Date());
            person.setActive(false);
            personRepository.save(person);
        }
    }

    @Transactional
    public Boolean existById(Long id) {
        return personRepository.existsById(id);
    }
}
