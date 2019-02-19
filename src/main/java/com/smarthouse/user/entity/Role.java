package com.smarthouse.user.entity;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;

public class Role {

    private final Long id;
    @Length(max = 255)
    @Pattern(regexp = "[A-Za-z0-9]*")
    private final String name;
    private final AccessLevel accessLevel;

    public Role(long id, String name, AccessLevel accessLevel) {
        this.id = id;
        this.name = name;
        this.accessLevel = accessLevel;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public AccessLevel getAccessLevel() {
        return accessLevel;
    }
}
