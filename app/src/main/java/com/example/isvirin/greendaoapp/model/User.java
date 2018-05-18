package com.example.isvirin.greendaoapp.model;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.Generated;

@Entity(indexes = {
        @Index(value = "firstName DESC", unique = true)
})
public class User {
    @Id
    private Long id;
    private String firstName;
    private String lastName;

    @Convert(converter = UserTypeConverter.class, columnType = String.class)
    private UserType type;
    public User() {
    }

    public User(Long id) {
        this.id = id;
    }


    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Generated(hash = 417117678)
    public User(Long id, String firstName, String lastName, UserType type) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.type = type;
    }
    
    public Long getUid() {
        return id;
    }

    public void setUid(Long uid) {
        this.id = uid;
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

    public UserType getType() {
        return this.type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
