package com.journal.journal.controllers.main.REST;

import com.journal.journal.enity.article.model.Article;
import com.journal.journal.enity.article.service.interfaces.ArticleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InitArticlesController {

    private final
    ArticleService articleService;

    public InitArticlesController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping("/api/getAllArticles")
    public List<Article> getAllArticles(){
        return articleService.findAll();
    }
}
