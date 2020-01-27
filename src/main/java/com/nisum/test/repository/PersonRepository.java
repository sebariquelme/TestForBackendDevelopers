package com.nisum.test.repository;

import com.nisum.test.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository <Person,Long> {

    Boolean existsByEmail(String email);

}
