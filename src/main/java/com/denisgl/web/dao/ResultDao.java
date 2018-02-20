package com.denisgl.web.dao;

import com.denisgl.web.dao.entity.Result;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ResultDao {
    @Autowired
    SessionFactory sessionFactory;

    public List<Result> findAll(){
        Session session = sessionFactory.openSession();
        List<Result> newsList = session.createQuery("SELECT r FROM Result r").getResultList();
        session.close();
        return newsList;
    }

    public void save(Result result){
            if(result == null){return;}
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.persist(result);
            tx.commit();
            session.close();
    }

}
