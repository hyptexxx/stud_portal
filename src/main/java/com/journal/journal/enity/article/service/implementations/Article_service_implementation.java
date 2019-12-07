package com.journal.journal.enity.article.service.implementations;

import com.journal.journal.enity.article.DAO.interfaces.Article_DAO;
import com.journal.journal.enity.article.model.Article;
import com.journal.journal.enity.article.service.interfaces.ArticleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Article_service_implementation implements ArticleService {
    private final
    Article_DAO article_dao;

    public Article_service_implementation(Article_DAO article_dao) {
        this.article_dao = article_dao;
    }

    @Override
    public List<Article> findAll() {
        return article_dao.findAll();
    }
}
