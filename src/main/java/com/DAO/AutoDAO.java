package com.DAO;

import com.Salon.Auto;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;
//DAO отвечают за предоставление CRUD-операций над таблицами базы данных//

@Repository //заключается в том, чтобы перехватывать специфичные исключения
// и перерабатывать их как одно из унифицированных непроверенных исключений Spring
public class AutoDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory s) {
        this.sessionFactory = s;
    }

    Logger logger = Logger.getLogger(String.valueOf(AutoDAO.class));


    //однопоточный объект, устанавливающий связь между объектами/сущностями приложения и базой данных.
    // Сессия создается при необходимости работы с БД и ее необходимо закрыть сразу же после использования.

    @SuppressWarnings("unchecked")
    public List<Auto> listAuto() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Auto> autoList = session.createQuery("SELECT p FROM Auto p").list();
        for(Auto p: autoList){
            System.out.println("INFO: "+ p);
            logger.info(p.toString());

        }
        return autoList;
    }
    public void addAuto(Auto s) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(s);
        logger.info("Auto successfully saved. Auto details: " + s);
    }
    public void updateAuto(Auto s) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(s);
        logger.info("Auto successfully update. Auto details: " + s);
    }
    public void deleteAuto(Integer id_auto) {
        Session session = this.sessionFactory.getCurrentSession();
        Auto auto = (Auto) session.load(Auto.class, id_auto);
        if(auto != null ){
            session.delete(auto);
        }
        logger.info("Auto successfully delete. Auto details: " + auto);
    }
    public Auto getIdC(Integer id_auto){
        try {
            Session session = this.sessionFactory.getCurrentSession();
            Auto auto = (Auto) session.load(Auto.class, id_auto);
            logger.info("Auto successfully loaded. Auto details: " + auto);
            return auto;
        } catch (Exception e) {
            return null;
        }
    }
}

