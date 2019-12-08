package com.journal.journal.enity.vkr_defends.DAO.implementations;

import com.journal.journal.configuration.HibernateUtils;
import com.journal.journal.enity.vkr_defends.DAO.interfaces.Vkr_defends_DAO;
import com.journal.journal.enity.vkr_defends.model.Vkr_defends;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class Vkr_defends_DAO_implementations implements Vkr_defends_DAO {

    private final
    HibernateUtils hibernateUtils;

    public Vkr_defends_DAO_implementations(HibernateUtils hibernateUtils) {
        this.hibernateUtils = hibernateUtils;
    }

    private static List<Vkr_defends> getArticleFromObject(List<Object[]> objects) {
        List<Vkr_defends> result = new ArrayList<>();
        for (Object[] row : objects) {
            result.add(new Vkr_defends((Date) row[0],
                    (String) row[1],
                    (String) row[2]));
        }
        return result;
    }

    @Override
    public List<Vkr_defends> findAll() {
        String SQL = "select v.date_def\n" +
                "     , u.fio user_fio\n" +
                "     , t.fio teacher_fio\n" +
                "from vkr v\n" +
                "         inner join teachers t\n" +
                "                    on t.id_teacher = v.id_teacher\n" +
                "         inner join users u\n" +
                "                    on u.user_id = v.user_id\n" +
                "where date_def IS NOT null";
        Session session = hibernateUtils.getSessionFactory().openSession();
        List<Vkr_defends> result = new ArrayList<>();
        Transaction trans = session.beginTransaction();
        List<Object[]> results = session.createSQLQuery(SQL).list();
        trans.commit();
        result = getArticleFromObject(results);
        return result;
    }
}
