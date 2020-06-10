package com.DAO;

import com.Salon.Selling;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SellingDAO {
    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    Logger logger = Logger.getLogger(String.valueOf(SellingDAO.class));


    @SuppressWarnings("unchecked")
    public List<Selling> listSelling() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Selling> sellingList = session.createQuery("SELECT p FROM Selling p").list();
        for(Selling p: sellingList){
            System.out.println("INFO: "+ p);
            logger.info(p.toString());

        }
        return sellingList;
    }
    public void addSelling(Selling s) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(s);
        logger.info("Selling successfully saved. Selling details: " + s);
    }
    public void updateSelling(Selling s) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(s);
        logger.info("Selling successfully update. Selling details: " + s);
    }
    public void deleteSelling(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        Selling selling = (Selling) session.load(Selling.class, id);
        if(selling != null ){
            session.delete(selling);
        }
        logger.info("Selling successfully delete. Selling details: " + selling);
    }
    public Selling getIdCl(Integer id){
        try {
            Session session = this.sessionFactory.getCurrentSession();
            Selling selling = (Selling) session.load(Selling.class, id);
            logger.info("Selling successfully loaded. Selling details: " + selling);
            return selling;
        } catch (Exception e) {
            return null;
        }
    }
}
