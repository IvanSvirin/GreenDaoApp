package com.example.isvirin.greendaoapp.model;

import io.realm.RealmObject;

public class User2 extends RealmObject {
    private Long id;
    private String firstName;
    private String lastName;

    public User2() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
