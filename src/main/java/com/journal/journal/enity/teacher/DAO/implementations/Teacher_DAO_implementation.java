package com.journal.journal.enity.teacher.DAO.implementations;

import com.journal.journal.configuration.HibernateUtils;
import com.journal.journal.enity.napr_podg.model.Napr_podg;
import com.journal.journal.enity.teacher.DAO.interfaces.Teacher_DAO_interface;
import com.journal.journal.enity.teacher.model.Teacher;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


@Repository
public class Teacher_DAO_implementation implements Teacher_DAO_interface {

    private final
    HibernateUtils hibernateUtils;

    public Teacher_DAO_implementation(HibernateUtils hibernateUtils) {
        this.hibernateUtils = hibernateUtils;
    }


    @Override
    public List<Teacher> findAll() {
        Session session = hibernateUtils.getSessionFactory().openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Teacher> cq = cb.createQuery(Teacher.class);
        Root<Teacher> rootEntry = cq.from(Teacher.class);
        CriteriaQuery<Teacher> all = cq.select(rootEntry);
        TypedQuery<Teacher> allQuery = session.createQuery(all);
        return allQuery.getResultList();
    }
}
