package org.example.cloudrest.Model;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 200)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;
}
