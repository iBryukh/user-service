package com.smarthouse.user.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Entity
public class Role {

    @Id
    @GeneratedValue
    private Long id;
    @Length(max = 255)
    @Pattern(regexp = "[A-Za-z0-9]*")
    private String name;
    @Min(0) // ADMIN
    @Max(3) // WEAK_OBSERVER
    private Integer accessLevel;



    public Role(long id, String name, Integer accessLevel) {
        this.id = id;
        this.name = name;
        this.accessLevel = accessLevel;
    }
    public Role(){}

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(Integer accessLevel) {
        this.accessLevel = accessLevel;
    }
}
