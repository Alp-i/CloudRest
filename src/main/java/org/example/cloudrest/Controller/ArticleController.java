package org.example.cloudrest.Controller;


import org.example.cloudrest.Model.Article;
import org.example.cloudrest.Service.ArticleService;
import org.example.cloudrest.Service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    private final AuthorService authorService;
    private final ArticleService articleService;

    public ArticleController(AuthorService authorService, ArticleService articleService) {
        this.authorService = authorService;
        this.articleService = articleService;
    }

    // GET /api/articles
    @GetMapping
    public ResponseEntity<List<Article>> getAllArticles() {
        List<Article> articles = articleService.getAllArticles();
        return ResponseEntity.ok(articles);
    }

    // POST /api/articles
    @PostMapping
    public ResponseEntity<Article> addArticle(@RequestBody Article article) {
        Article savedArticle = articleService.saveArticle(article);
        return new ResponseEntity<>(savedArticle, HttpStatus.CREATED);
    }

    // DELETE /api/articles/{id}
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteArticle(@PathVariable int id) {
        try {
            articleService.deleteArticle(id);
            return ResponseEntity.ok("Article deleted successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting article!");
        }
    }

    // GET /api/articles/{id}
    @GetMapping("{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable int id) {
        Article article = articleService.getArticleById(id);
        if (article != null) {
            return ResponseEntity.ok(article);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // PUT /api/articles/{id}
    @PutMapping("{id}")
    public ResponseEntity<String> updateArticle(@PathVariable int id, @RequestBody Article updatedArticle) {
        Article existingArticle = articleService.getArticleById(id);
        if (existingArticle == null) {
            return ResponseEntity.notFound().build();
        }
        updatedArticle.setId(id);
        articleService.updateArticle(updatedArticle);
        return ResponseEntity.ok("Article updated successfully!");
    }

}