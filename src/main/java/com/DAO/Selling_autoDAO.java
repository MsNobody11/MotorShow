package com.DAO;


import com.Salon.Selling_auto;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Selling_autoDAO {
    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    Logger logger = Logger.getLogger(String.valueOf(Selling_autoDAO.class));


    @SuppressWarnings("unchecked")
    public List<Selling_auto> listSelling_auto() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Selling_auto> selling_autoList = session.createQuery("SELECT p FROM Selling_auto p").list();
        for(Selling_auto p: selling_autoList){
            System.out.println("INFO: "+ p);
            logger.info(p.toString());

        }
        return selling_autoList;
    }
    public void addSelling_auto(Selling_auto s) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(s);
        logger.info("Selling_auto successfully saved. Selling_auto details: " + s);
    }
    public void updateSelling_auto(Selling_auto s) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(s);
        logger.info("Selling_auto successfully update. Selling_auto details: " + s);
    }
    public void deleteSelling_auto(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        Selling_auto selling_auto = (Selling_auto) session.load(Selling_auto.class, id);
        if(selling_auto != null ){
            session.delete(selling_auto);
        }
        logger.info("Selling_auto successfully delete. Selling_auto details: " + selling_auto);
    }
    public Selling_auto getId(Integer id){
        try {
            Session session = this.sessionFactory.getCurrentSession();
            Selling_auto selling_auto = (Selling_auto) session.load(Selling_auto.class, id);
            logger.info("Selling_auto successfully loaded. Selling_auto details: " + selling_auto);
            return selling_auto;
        } catch (Exception e) {
            return null;
        }
    }
}
