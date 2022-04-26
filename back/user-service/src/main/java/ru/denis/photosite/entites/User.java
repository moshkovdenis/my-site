package ru.denis.photosite.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.UUID;

@Entity(name = "users")
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "name", unique = false)
    private String name;

    @Column(name = "age", unique = false)
    private int age;

    @Column(name = "email", unique = true)
    private String email;

    @Transient
    @JsonIgnore
    private boolean exist;

    public User(boolean exist) {
        this.exist = exist;
    }

    public User(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public User(UUID id, String name, int age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }
}
