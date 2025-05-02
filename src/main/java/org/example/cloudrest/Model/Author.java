package org.example.cloudrest.Model;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column( length = 100)
    private String name;

    @Column( length = 255)
    private String address;
}
