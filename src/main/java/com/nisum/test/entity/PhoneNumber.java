package com.nisum.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "PHONE_NUMBER")
public class PhoneNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_phone")
    private long id;
    private long number;
    private int countryCode;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id",referencedColumnName="id",nullable=false,unique=true )
    private Person person;
}
