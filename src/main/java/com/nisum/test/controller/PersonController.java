package com.nisum.test.controller;

import com.nisum.test.dto.PersonDto;
import com.nisum.test.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("person")
public class PersonController {
  @Autowired
  private PersonService personService;

    @GetMapping("/list")
    public List<PersonDto> list() {
        return personService.findAll();
    }

    @GetMapping("/findById")
    public PersonDto findById(Long id) {
        return personService.findById(id);
    }

    @PostMapping("/save")
    public PersonDto save(PersonDto obj) {
        return personService.save(obj);
    }

    @DeleteMapping("/delete")
    public void delete(Long id) {
        personService.deleteById(id);
    }

}
