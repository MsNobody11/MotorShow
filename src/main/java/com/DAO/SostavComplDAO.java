package com.DAO;


import com.Salon.SostavCompl;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SostavComplDAO {
    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    Logger logger = Logger.getLogger(String.valueOf(SostavComplDAO.class));


    @SuppressWarnings("unchecked")
    public List<SostavCompl> listSostavCompl() {
        Session session = this.sessionFactory.getCurrentSession();
        List<SostavCompl> sostavcomplList = session.createQuery("SELECT p FROM SostavCompl p").list();
        for(SostavCompl p: sostavcomplList){
            System.out.println("INFO: "+ p);
            logger.info(p.toString());

        }
        return sostavcomplList;
    }
    public void addSostavCompl(SostavCompl s) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(s);
        logger.info("SostavCompl successfully saved. SostavCompl details: " + s);
    }
    public void updateSostavCompl(SostavCompl s) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(s);
        logger.info("SostavCompl successfully update. SostavCompl details: " + s);
    }
    public void deleteSostavCompl(Integer kodelement) {
        Session session = this.sessionFactory.getCurrentSession();
        SostavCompl sostavcompl = (SostavCompl) session.load(SostavCompl.class, kodelement);
        if(sostavcompl != null ){
            session.delete(sostavcompl);
        }
        logger.info("SostavCompl successfully delete. SostavCompl details: " + sostavcompl);
    }
    public SostavCompl getId(Integer kodelement){
        try {
            Session session = this.sessionFactory.getCurrentSession();
            SostavCompl sostavcompl = (SostavCompl) session.load(SostavCompl.class, kodelement);
            logger.info("SostavCompl successfully loaded. SostavCompl details: " + sostavcompl);
            return sostavcompl;
        } catch (Exception e) {
            return null;
        }
    }
}
