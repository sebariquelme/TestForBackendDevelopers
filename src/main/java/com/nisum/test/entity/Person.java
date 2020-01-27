package com.nisum.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.Set;

@Entity
@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PERSON")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    private Date created;

    @Column(name = "update_at")
    @Temporal(TemporalType.DATE)
    private Date modified;

    @Column(name = "delete_at")
    @Temporal(TemporalType.DATE)
    private Date deleted;

    @Column(name = "last_login")
    @Temporal(TemporalType.DATE)
    private Date lastLogin;

    @Column(name = "is_active")
    private boolean isActive;

    private String token;

    private String name;

    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
    private String email;

    @Pattern(regexp = "^(?=.*\\d{2,})(?=.*[a-z])(?=.*[A-Z]{1,})(?=.*[a-zA-Z]).{6,}$")
    private String password;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "person")
    private Set<PhoneNumber> phones;

}
