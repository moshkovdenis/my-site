package ru.denis.photosite.entites;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Comment {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "content")
    private String content;

    @JsonBackReference
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "client_id")
    private Client clientId;

    public Comment(Client client) {
        this.clientId = client;
    }

}
