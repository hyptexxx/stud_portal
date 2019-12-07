package com.journal.journal.configuration;

import com.journal.journal.enity.article.model.Article;
import com.journal.journal.enity.list_category.model.List_category;
import com.journal.journal.enity.list_kafedr.model.List_kafedr;
import com.journal.journal.enity.teacher.model.Teacher;
import com.journal.journal.enity.napr_podg.model.Napr_podg;
import com.journal.journal.enity.science_piblication.model.Science_publication;
import com.journal.journal.enity.users.model.Users;
import com.journal.journal.enity.vkr.model.Vkr;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class HibernateUtils {
    private static SessionFactory sessionFactory;

    private HibernateUtils() {}

    public  SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/journal?serverTimezone=UTC");
                settings.put(Environment.USER, "root");
                settings.put(Environment.PASS, "root");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "org.springframework.orm.hibernate5.SpringSessionContext");
                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.FORMAT_SQL, "true");
                settings.put(Environment.HBM2DDL_AUTO, "none");
                configuration.setProperties(settings);
                configuration.addAnnotatedClass(List_category.class);
                configuration.addAnnotatedClass(List_kafedr.class);
                configuration.addAnnotatedClass(Teacher.class);
                configuration.addAnnotatedClass(Napr_podg.class);
                configuration.addAnnotatedClass(Science_publication.class);
                configuration.addAnnotatedClass(Users.class);
                configuration.addAnnotatedClass(Vkr.class);
                configuration.addAnnotatedClass(Article.class);
                registryBuilder.applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory();
            } catch (Exception e) {
                System.out.println("Исключение!" + e);
            }
        }
        return sessionFactory;
    }
}
