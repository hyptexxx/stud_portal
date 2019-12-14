package com.journal.journal.enity.users.DAO.implementations;

import com.journal.journal.configuration.HibernateUtils;
import com.journal.journal.enity.teacher.model.Teacher;
import com.journal.journal.enity.users.DAO.interfaces.Users_DAO_interface;
import com.journal.journal.enity.users.model.Users;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;


@Repository
public class Users_DAO_implementation implements Users_DAO_interface {

    private final
    HibernateUtils hibernateUtils;

    public Users_DAO_implementation(HibernateUtils hibernateUtils) {
        this.hibernateUtils = hibernateUtils;
    }

    @Override
    public List<Users> findAll() {
        Session session = hibernateUtils.getSessionFactory().openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Users> cq = cb.createQuery(Users.class);
        Root<Users> rootEntry = cq.from(Users.class);
        CriteriaQuery<Users> all = cq.select(rootEntry);
        TypedQuery<Users> allQuery = session.createQuery(all);
        return allQuery.getResultList();
    }

    @Override
    public List<Users> findAllByTeacherId(int id_teacher) {
        String SQL = "select u.user_id,\n" +
                "       u.fio,\n" +
                "       u.id_napr,\n" +
                "       u.id_category\n" +
                "from vkr v\n" +
                "         inner join users u\n" +
                "                    on u.user_id = v.user_id\n" +
                "where id_teacher = :id_teacher";
        Session session = hibernateUtils.getSessionFactory().openSession();
        List<Users> result = new ArrayList<>();
        Transaction trans = session.beginTransaction();
        List<Object[]> results = session.createSQLQuery(SQL) .setParameter("id_teacher", id_teacher).list();
        trans.commit();
        for (Object[] row : results) {
            result.add(new Users((Integer) row[0], (String) row[1], (Integer) row[2], (Integer) row[3]));
        }
        return result;
    }
}
