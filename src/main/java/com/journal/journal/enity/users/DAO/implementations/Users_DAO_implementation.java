package com.journal.journal.enity.users.DAO.implementations;

import com.journal.journal.configuration.HibernateUtils;
import com.journal.journal.enity.users.DAO.interfaces.Users_DAO_interface;
import com.journal.journal.enity.users.model.Users;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
        return null;
    }
}
