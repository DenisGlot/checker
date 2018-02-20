package com.denisgl.web.repository;

import com.denisgl.web.dao.entity.Result;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Date;

@Repository
public class InitSessionFactory {

    final static Logger logger = Logger.getLogger(InitSessionFactory.class);

    private static SessionFactory sessionFactory;

    private static SessionFactory buildSessionFactory(){
        return new Configuration().configure().addAnnotatedClass(Result.class).buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null) {
            synchronized (InitSessionFactory.class){
                sessionFactory = buildSessionFactory();
            }
        }
        return sessionFactory;
    }


    private static boolean isInitialized;

    @PostConstruct
    public void init() {
        if(!isInitialized) {
            sessionFactory = getSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            Result result = new Result();
            result.setWinner("Draw");
            result.setDate(new Date());
            session.persist(result);
            tx.commit();
            session.close();
        }
        isInitialized =true;
    }
}
