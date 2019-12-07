package com.journal.journal.enity.napr_podg.DAO.implementations;

import com.journal.journal.configuration.HibernateUtils;
import com.journal.journal.enity.list_category.model.List_category;
import com.journal.journal.enity.napr_podg.DAO.interfaces.Napr_podg_DAO_interface;
import com.journal.journal.enity.napr_podg.model.Napr_podg;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


@Repository
public class Napr_podg_DAO_implementation implements Napr_podg_DAO_interface {

    private final
    HibernateUtils hibernateUtils;

    public Napr_podg_DAO_implementation(HibernateUtils hibernateUtils) {
        this.hibernateUtils = hibernateUtils;
    }

    @Override
    public List<Napr_podg> findAll() {

        Session session = hibernateUtils.getSessionFactory().openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Napr_podg> cq = cb.createQuery(Napr_podg.class);
        Root<Napr_podg> rootEntry = cq.from(Napr_podg.class);
        CriteriaQuery<Napr_podg> all = cq.select(rootEntry);
        TypedQuery<Napr_podg> allQuery = session.createQuery(all);
        return allQuery.getResultList();
    }
}
