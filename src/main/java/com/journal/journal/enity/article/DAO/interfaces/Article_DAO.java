package com.journal.journal.enity.article.DAO.interfaces;

import com.journal.journal.enity.article.model.Article;

import java.util.List;

public interface Article_DAO {
    List<Article> findAll();
    List<Article> findAllByKafId(int kaf_id);
    List<Article> findAllByNr(int nr_id);
    List<Article> findAllByKafAndNrId(int kaf_id, int nr_id);
}
