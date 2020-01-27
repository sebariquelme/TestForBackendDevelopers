package com.nisum.test.dto;

import com.nisum.test.entity.PhoneNumber;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@Builder
public class PersonDto {
    private long id;
    private Date created;
    private Date modified;
    private Date deleted;
    private Date lastLogin;
    private boolean isActive;
    private String token;
    private String name;
    private String email;
    private String password;
    private Set<PhoneNumber> phoneNumbers;
}
