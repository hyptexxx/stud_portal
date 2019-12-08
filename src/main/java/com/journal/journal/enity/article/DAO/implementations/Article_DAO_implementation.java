package com.journal.journal.enity.article.DAO.implementations;

import com.journal.journal.configuration.HibernateUtils;
import com.journal.journal.enity.article.DAO.interfaces.Article_DAO;
import com.journal.journal.enity.article.model.Article;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class Article_DAO_implementation implements Article_DAO {

    private final
    HibernateUtils hibernateUtils;

    public Article_DAO_implementation(HibernateUtils hibernateUtils) {
        this.hibernateUtils = hibernateUtils;
    }


    private static List<Article> getArticleFromObject(List<Object[]> objects) {
        List<Article> result = new ArrayList<>();
        for (Object[] row : objects) {
            result.add(new Article((Integer) row[0],
                    (String) row[1],
                    (Integer) row[2],
                    (String) row[3],
                    (Integer) row[4],
                    (String) row[5],
                    (Integer) row[6],
                    (String) row[7]));
        }
        return result;
    }

    @Override
    public List<Article> findAll() {
        String SQL = "select u.user_id\n" +
                "     , u.fio f\n" +
                "     , t.id_teacher\n" +
                "     , t.fio a\n" +
                "     , n.id_napr\n" +
                "     , n.name\n" +
                "     , lc.id_category\n" +
                "     , lc.description\n" +
                "from users u\n" +
                "         inner join vkr v\n" +
                "                    on v.user_id = u.user_id\n" +
                "         inner join teachers t\n" +
                "                    on t.id_teacher = v.id_teacher\n" +
                "         inner join napr_podg n\n" +
                "                    on u.id_napr = n.id_napr\n" +
                "         inner join list_category lc\n" +
                "                    on u.id_category = lc.id_category";
        Session session = hibernateUtils.getSessionFactory().openSession();
        List<Article> result = new ArrayList<>();
        Transaction trans = session.beginTransaction();
        List<Object[]> results = session.createSQLQuery(SQL).list();
        trans.commit();
        result = getArticleFromObject(results);
        return result;
    }

    @Override
    public List<Article> findAllByKafId(int kaf_id) {
        String SQL = "select u.user_id\n" +
                "     , u.fio f\n" +
                "     , t.id_teacher\n" +
                "     , t.fio a\n" +
                "     , n.id_napr\n" +
                "     , n.name\n" +
                "     , lc.id_category\n" +
                "     , lc.description\n" +
                "from users u\n" +
                "         inner join vkr v\n" +
                "                    on v.user_id = u.user_id\n" +
                "         inner join teachers t\n" +
                "                    on t.id_teacher = v.id_teacher\n" +
                "         inner join napr_podg n\n" +
                "                    on u.id_napr = n.id_napr\n" +
                "         inner join list_category lc\n" +
                "                    on u.id_category = lc.id_category\n" +
                "         inner join list_kafedr lk\n" +
                "                    on lk.id_kafedr = n.id_kaf\n" +
                "WHERE lk.id_kafedr = :kaf_id";
        Session session = hibernateUtils.getSessionFactory().openSession();
        List<Article> result = new ArrayList<>();
        Transaction trans = session.beginTransaction();
        List<Object[]> results = session.createSQLQuery(SQL).setParameter("kaf_id", kaf_id).list();
        trans.commit();
        result = getArticleFromObject(results);
        return result;
    }

    @Override
    public List<Article> findAllByNr(int nr_id) {
        String SQL = "select u.user_id\n" +
                "     , u.fio f\n" +
                "     , t.id_teacher\n" +
                "     , t.fio a\n" +
                "     , n.id_napr\n" +
                "     , n.name\n" +
                "     , lc.id_category\n" +
                "     , lc.description\n" +
                "from users u\n" +
                "         inner join vkr v\n" +
                "                    on v.user_id = u.user_id\n" +
                "         inner join teachers t\n" +
                "                    on t.id_teacher = v.id_teacher\n" +
                "         inner join napr_podg n\n" +
                "                    on u.id_napr = n.id_napr\n" +
                "         inner join list_category lc\n" +
                "                    on u.id_category = lc.id_category\n" +
                "         inner join list_kafedr lk\n" +
                "                    on lk.id_kafedr = n.id_kaf\n" +
                "WHERE v.id_teacher = :nr_id";
        Session session = hibernateUtils.getSessionFactory().openSession();
        List<Article> result = new ArrayList<>();
        Transaction trans = session.beginTransaction();
        List<Object[]> results = session.createSQLQuery(SQL).setParameter("nr_id", nr_id).list();
        trans.commit();
        result = getArticleFromObject(results);
        return result;
    }

    @Override
    public List<Article> findAllByKafAndNrId(int kaf_id, int nr_id) {
        String SQL = "select u.user_id\n" +
                "     , u.fio f\n" +
                "     , t.id_teacher\n" +
                "     , t.fio a\n" +
                "     , n.id_napr\n" +
                "     , n.name\n" +
                "     , lc.id_category\n" +
                "     , lc.description\n" +
                "from users u\n" +
                "         inner join vkr v\n" +
                "                    on v.user_id = u.user_id\n" +
                "         inner join teachers t\n" +
                "                    on t.id_teacher = v.id_teacher\n" +
                "         inner join napr_podg n\n" +
                "                    on u.id_napr = n.id_napr\n" +
                "         inner join list_category lc\n" +
                "                    on u.id_category = lc.id_category\n" +
                "         inner join list_kafedr lk\n" +
                "                    on lk.id_kafedr = n.id_kaf\n" +
                "WHERE v.id_teacher = :nr_id\n" +
                "  and lk.id_kafedr = :kaf_id";
        Session session = hibernateUtils.getSessionFactory().openSession();
        List<Article> result = new ArrayList<>();
        Transaction trans = session.beginTransaction();
        List<Object[]> results = session.createSQLQuery(SQL)
                .setParameter("nr_id", nr_id)
                .setParameter("kaf_id", kaf_id)
                .list();
        trans.commit();
        result = getArticleFromObject(results);
        return result;
    }
}
