package com.smarthouse.user.entity;

public class Role {

    private final long id;
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
