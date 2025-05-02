package org.example.cloudrest.Service;

import org.example.cloudrest.Model.Article;
import org.example.cloudrest.Repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    public Article getArticleById(int id) {
        return articleRepository.findById(id).orElseThrow(()->new RuntimeException("Article not found"));
    }

    public Article saveArticle(Article article) {
        return articleRepository.save(article);
    }

    public void updateArticle(Article updatedArticle) {
        articleRepository.save(updatedArticle);
    }

    public void deleteArticle(int id) {
        articleRepository.deleteById(id);
    }
}
