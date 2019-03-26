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
    private Long id;
    @Length(max = 255, min = 1)
    @Pattern(regexp = "[A-Za-z][A-Za-z0-9]*")
    private String name;
    @Length(max = 255, min = 3)
    private String email;
    @Length(max = 255, min = 1)
    private String phoneNumber;
    @Length(max = 255, min = 6)
    private String password;
    @ManyToOne
    private Role role;

    public User() {
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
