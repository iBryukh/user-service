package com.smarthouse.user.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Pattern;

@Entity(name = "customer")
public class User {

    @Id
    @GeneratedValue
    private final Long id;
    @Length(max = 255, min = 1)
    @Pattern(regexp = "[A-Za-z][A-Za-z0-9]*")
    private final String name;
    @Length(max = 255, min = 3)
    private final String email;
    @Length(max = 255, min = 1)
    private final String phoneNumber;
    @Length(max = 255, min = 6)
    private final String password;
    @ManyToOne
    private Role role;

    public User(Long id, String name, String email, String phoneNumber, String password, Role role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }
}
