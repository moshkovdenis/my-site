package ru.denis.photosite.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity(name = "client")
@NoArgsConstructor
@Data
@Table(name = "client")
@Builder
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "name", unique = false)
    private String name;

    @Column(name = "age", unique = false)
    private int age;

    @Column(name = "email", unique = true)
    private String email;

    @JsonManagedReference
    @OneToMany(mappedBy = "clientId",cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Comment> comments = new ArrayList<>();

    @Transient
    @JsonIgnore
    private boolean exist;

    public Client(boolean exist) {
        this.exist = exist;
    }

    public Client(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public Client(UUID id, String name, int age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }
}
