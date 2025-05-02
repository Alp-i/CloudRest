package org.example.cloudrest.Repository;

import org.example.cloudrest.Model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article ,Integer> {
}
