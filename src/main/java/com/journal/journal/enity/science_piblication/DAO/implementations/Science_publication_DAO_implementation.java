package com.journal.journal.enity.science_piblication.DAO.implementations;

import com.journal.journal.configuration.HibernateUtils;
import com.journal.journal.enity.article.model.Article;
import com.journal.journal.enity.science_piblication.DAO.interfaces.Science_publication_DAO_interface;
import com.journal.journal.enity.science_piblication.model.Science_publication;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria. CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class Science_publication_DAO_implementation implements Science_publication_DAO_interface {

    private final
    HibernateUtils hibernateUtils;

    public Science_publication_DAO_implementation(HibernateUtils hibernateUtils) {
        this.hibernateUtils = hibernateUtils;
    }

    @Override
    public List<Science_publication> findAll() {
        Session session = hibernateUtils.getSessionFactory().openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Science_publication> cq = cb.createQuery(Science_publication.class);
        Root<Science_publication> rootEntry = cq.from(Science_publication.class);
        CriteriaQuery<Science_publication> all = cq.select(rootEntry);
        TypedQuery<Science_publication> allQuery = session.createQuery(all);
        return allQuery.getResultList();
    }

    private static List<Science_publication> getArticleFromObject(List<Object[]> objects) {
        List<Science_publication> result = new ArrayList<>();
        for (Object[] row : objects) {
            result.add(new Science_publication((Integer) row[0],
                    (String) row[1],
                    (String) row[2],
                    (Integer) row[3],
                    (Integer) row[4]));
        }
        return result;
    }

    @Override
    public List<Science_publication> findAllByNr(int id_teacher) {
        String SQL = "select sp.id_science_publication,\n" +
                "       sp.name,\n" +
                "       sp.text,\n" +
                "       sp.user_id,\n" +
                "       sp.teacher_id\n" +
                "from science_publication sp\n" +
                "where sp.teacher_id = :id_teacher";
        Session session = hibernateUtils.getSessionFactory().openSession();
        List<Science_publication> result = new ArrayList<>();
        Transaction trans = session.beginTransaction();
        List<Object[]> results = session.createSQLQuery(SQL).setParameter("id_teacher",id_teacher).list();
        trans.commit();
        result = getArticleFromObject(results);
        return result;
    }

    @Override
    public List<Science_publication> findAllByStudentId(int id_student) {
        String SQL = "select sp.id_science_publication,\n" +
                "       sp.name,\n" +
                "       sp.text,\n" +
                "       sp.user_id,\n" +
                "       sp.teacher_id\n" +
                "from science_publication sp\n" +
                "where sp.user_id = :id_student";
        Session session = hibernateUtils.getSessionFactory().openSession();
        List<Science_publication> result = new ArrayList<>();
        Transaction trans = session.beginTransaction();
        List<Object[]> results = session.createSQLQuery(SQL).setParameter("id_student",id_student).list();
        trans.commit();
        result = getArticleFromObject(results);
        return result;
    }

    @Override
    public List<Science_publication> findAllByStudentAndNrId(int id_student, int id_teacher) {
        return null;
    }
}
