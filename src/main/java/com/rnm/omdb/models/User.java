package com.rnm.omdb.models;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.List;
//This is the table for a user in the mySQL database using spring to define the values
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(nullable = false, length = 100)
    private String first_name;

    @Column(nullable = false, length = 100)
    private String last_name;

    @Column(nullable = false, length = 255, unique = true)
    private String username;

    @Pattern(regexp="^(?=.*?[A-Z])(?=.*?[0-9]).{8,}$",message="Password length must be at least 8 characters with one uppercase letter and one digit")
    @Column(nullable = false)
    private String password;

    public User() {}


    public User(User copy) {
        this.id = copy.id; // This line is SUPER important! Many things won't work if it's absent
        this.username = copy.username;
        this.password = copy.password;
        this.last_name = copy.last_name;
        this.first_name = copy.first_name;
    }

// These are the getters and setters for the private instances, they are public accessors

    public Integer getId() { return id;}

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", userName='" + getUsername() + "'" + ", password='" + getPassword()
                + "'" + "}";
    }


}
