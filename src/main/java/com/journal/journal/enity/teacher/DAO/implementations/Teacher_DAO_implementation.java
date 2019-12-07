package com.journal.journal.enity.teacher.DAO.implementations;

import com.journal.journal.configuration.HibernateUtils;
import com.journal.journal.enity.napr_podg.model.Napr_podg;
import com.journal.journal.enity.teacher.DAO.interfaces.Teacher_DAO_interface;
import com.journal.journal.enity.teacher.model.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
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

    @Override
    public List<Teacher> findAllByKafedrId(int id_kaf) {
        String SQL = "select\n" +
                "       t.id_teacher\n" +
                "     , t.id_n"+
                "    ,   t.fio\n" +
                "from teachers t\n" +
                "         inner join napr_podg n\n" +
                "                    on t.id_n = n.id_napr\n" +
                "         inner join list_kafedr lk\n" +
                "                    on lk.id_kafedr = n.id_kaf\n" +
                "where lk.id_kafedr = :id_kaf";
        Session session = hibernateUtils.getSessionFactory().openSession();
        List<Teacher> result = new ArrayList<>();
        Transaction trans = session.beginTransaction();
        List<Object[]> results = session.createSQLQuery(SQL) .setParameter("id_kaf", id_kaf).list();
        trans.commit();
        for (Object[] row : results) {
            result.add(new Teacher((Integer) row[0], (Integer) row[1], (String) row[2]));
        }
        return result;
    }
}
