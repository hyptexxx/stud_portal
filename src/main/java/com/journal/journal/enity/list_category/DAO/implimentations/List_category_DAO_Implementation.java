package com.journal.journal.enity.list_category.DAO.implimentations;

import com.journal.journal.configuration.HibernateUtils;
import com.journal.journal.enity.list_category.DAO.interfaces.List_category_DAO;
import com.journal.journal.enity.list_category.model.List_category;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class List_category_DAO_Implementation implements List_category_DAO {

    private final
    HibernateUtils hibernateUtils;

    public List_category_DAO_Implementation(HibernateUtils hibernateUtils) {
        this.hibernateUtils = hibernateUtils;
    }

    @Override
    public List<List_category> getAll() {
        Session session = hibernateUtils.getSessionFactory().openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<List_category> cq = cb.createQuery(List_category.class);
        Root<List_category> rootEntry = cq.from(List_category.class);
        CriteriaQuery<List_category> all = cq.select(rootEntry);
        TypedQuery<List_category> allQuery = session.createQuery(all);
        return allQuery.getResultList();
    }
}
