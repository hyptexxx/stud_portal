package com.journal.journal.enity.vkr.DAO.implementations;

import com.journal.journal.configuration.HibernateUtils;
import com.journal.journal.enity.vkr.DAO.interfaces.Vkr_DAO_interface;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class Vkr_DAO_implementation implements Vkr_DAO_interface {

    private final
    HibernateUtils hibernateUtils;

    public Vkr_DAO_implementation(HibernateUtils hibernateUtils) {
        this.hibernateUtils = hibernateUtils;
    }

    @Override
    public void updateVkrByUserId(int user_id, int teacher) {
        Session session = hibernateUtils.getSessionFactory().openSession();
        session.getTransaction().begin();
        Query query = session.createSQLQuery(
                "update vkr\n" +
                        "set id_teacher = :teacher\n" +
                        "WHERE user_id = :user_id");
        query.setParameter("teacher", teacher);
        query.setParameter("user_id", user_id);
        int result = query.executeUpdate();
        session.getTransaction().commit();
    }
}
