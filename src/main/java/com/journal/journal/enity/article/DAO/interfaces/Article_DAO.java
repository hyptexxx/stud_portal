package com.journal.journal.enity.article.DAO.interfaces;

import com.journal.journal.enity.article.model.Article;

import java.util.List;

public interface Article_DAO {
    List<Article> findAll();
}
