package com.nisum.test.entity;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Date;

@Data
@MappedSuperclass
@SuperBuilder
public class BaseEntity {

    public BaseEntity(){
        this.created = new Date();
    }

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


}
