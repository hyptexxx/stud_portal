package com.journal.journal.enity.list_kafedr.DAO.implementations;

import com.journal.journal.configuration.HibernateUtils;
import com.journal.journal.enity.list_kafedr.DAO.interfaces.List_kafedr_DAO_interface;
import com.journal.journal.enity.list_kafedr.model.List_kafedr;
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

    @Override
    public List<List_kafedr> findAllByTeacherId(int id_teacher) {
        String SQL = "select\n" +
                "       lk.name\n" +
                "        ,   lk.id_kafedr\n" +
                "from list_kafedr lk\n" +
                "\n" +
                "inner join napr_podg np\n" +
                "    on np.id_kaf = lk.id_kafedr\n" +
                "inner join teachers t\n" +
                "               on t.id_n = np.id_napr\n" +
                "where t.id_teacher = :id_teacher";
        Session session = hibernateUtils.getSessionFactory().openSession();
        List<List_kafedr> result = new ArrayList<>();
        Transaction trans = session.beginTransaction();
        List<Object[]> results = session.createSQLQuery(SQL).setParameter("id_teacher", id_teacher).list();
        trans.commit();
        for (Object[] row : results) {
            result.add(new List_kafedr((Integer) row[1],  (String) row[0]));
        }
        return result;
    }
}
