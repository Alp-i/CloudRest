package org.example.cloudrest.Repository;

import org.example.cloudrest.Model.Author;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
