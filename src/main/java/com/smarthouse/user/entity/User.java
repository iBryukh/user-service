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

    public User(final long id, final String name, final String email, final String phoneNumber, final String password, final Role role) {
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
