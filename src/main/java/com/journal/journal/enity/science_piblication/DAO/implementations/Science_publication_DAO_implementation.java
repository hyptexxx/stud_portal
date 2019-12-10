package com.journal.journal.enity.science_piblication.DAO.implementations;

import com.journal.journal.configuration.HibernateUtils;
import com.journal.journal.enity.science_piblication.DAO.interfaces.Science_publication_DAO_interface;
import com.journal.journal.enity.science_piblication.model.Science_publication;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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

    @Override
    public List<Science_publication> findAllByNr(int id_teacher) {
        return null;
    }

    @Override
    public List<Science_publication> findAllByStudentId(int id_student) {
        return null;
    }

    @Override
    public List<Science_publication> findAllByStudentAndNrId(int id_student, int id_teacher) {
        return null;
    }
}
