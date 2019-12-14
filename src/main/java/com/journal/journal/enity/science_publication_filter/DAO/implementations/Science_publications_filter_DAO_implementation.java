package com.journal.journal.enity.science_publication_filter.DAO.implementations;

import com.journal.journal.configuration.HibernateUtils;
import com.journal.journal.enity.science_piblication.model.Science_publication;
import com.journal.journal.enity.science_publication_filter.DAO.interfaces.Science_publications_filter_DAO;
import com.journal.journal.enity.science_publication_filter.model.Science_publication_filter;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class Science_publications_filter_DAO_implementation implements Science_publications_filter_DAO {

    private final
    HibernateUtils hibernateUtils;

    public Science_publications_filter_DAO_implementation(HibernateUtils hibernateUtils) {
        this.hibernateUtils = hibernateUtils;
    }

    private static List<Science_publication_filter> getArticleFromObject(List<Object[]> objects) {
        List<Science_publication_filter> result = new ArrayList<>();
        for (Object[] row : objects) {
            result.add(new Science_publication_filter((String) row[0],
                    (String) row[1],
                    (String) row[2]));
        }
        return result;
    }

    @Override
    public List<Science_publication_filter> findAllByStudentId(int user_id) {
        String SQL = "select sp.name,\n" +
                "       sp.text,\n" +
                "       t.fio\n" +
                "from vkr v\n" +
                "         inner join science_publication sp\n" +
                "                    on v.id_teacher = sp.teacher_id\n" +
                "         inner join teachers t\n" +
                "                    on t.id_teacher = v.id_teacher\n" +
                "where v.user_id = :user_id" +
                "  and sp.teacher_id is not null";
        Session session = hibernateUtils.getSessionFactory().openSession();
        List<Science_publication_filter> result = new ArrayList<>();
        Transaction trans = session.beginTransaction();
        List<Object[]> results = session.createSQLQuery(SQL).setParameter("user_id", user_id).list();
        trans.commit();
        result = getArticleFromObject(results);
        return result;
    }
}
