package com.journal.journal.enity.list_kafedr.DAO.implementations;

import com.journal.journal.configuration.HibernateUtils;
import com.journal.journal.enity.list_category.model.List_category;
import com.journal.journal.enity.list_kafedr.DAO.interfaces.List_kafedr_DAO_interface;
import com.journal.journal.enity.list_kafedr.model.List_kafedr;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class List_kafedr_DAO_implementation implements List_kafedr_DAO_interface {

    private final
    HibernateUtils hibernateUtils;

    public List_kafedr_DAO_implementation(HibernateUtils hibernateUtils) {
        this.hibernateUtils = hibernateUtils;
    }


    @Override
    public List<List_kafedr> findAll() {
        Session session = hibernateUtils.getSessionFactory().openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<List_kafedr> cq = cb.createQuery(List_kafedr.class);
        Root<List_kafedr> rootEntry = cq.from(List_kafedr.class);
        CriteriaQuery<List_kafedr> all = cq.select(rootEntry);
        TypedQuery<List_kafedr> allQuery = session.createQuery(all);
        return allQuery.getResultList();
    }
}
