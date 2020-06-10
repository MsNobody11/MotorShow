package com.DAO;


import com.Salon.Complect;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ComplectDAO {
    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    Logger logger = Logger.getLogger(String.valueOf(ComplectDAO.class));


    @SuppressWarnings("unchecked")
    public List<Complect> listComplect() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Complect> complectList = session.createQuery("SELECT p FROM Complect p").list();
        for(Complect p: complectList){
            System.out.println("INFO: "+ p);
            logger.info(p.toString());

        }
        return complectList;
    }
    public void addComplect(Complect s) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(s);
        logger.info("Complect successfully saved. Complect details: " + s);
    }
    public void updateComplect(Complect s) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(s);
        logger.info("Complect successfully update. Complect details: " + s);
    }
    public void deleteComplect(Integer kodcompl) {
        Session session = this.sessionFactory.getCurrentSession();
        Complect complect = (Complect) session.load(Complect.class, kodcompl);
        if(complect != null ){
            session.delete(complect);
        }
        logger.info("Complect successfully delete. Complect details: " + complect);
    }
    public Complect getId(Integer kodcompl){
        try {
            Session session = this.sessionFactory.getCurrentSession();
            Complect complect = (Complect) session.load(Complect.class, kodcompl);
            logger.info("Complect successfully loaded. Complect details: " + complect);
            return complect;
        } catch (Exception e) {
            return null;
        }
    }
}
