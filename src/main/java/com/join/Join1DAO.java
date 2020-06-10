package com.join;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.logging.Logger;

@Repository
public class Join1DAO {
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sf){this.sessionFactory = sf;}
    Logger logger = Logger.getLogger(String.valueOf(Join1DAO.class));

    //Запрос выводит информацию о проданных автомобилях и количество их продаж
    @SuppressWarnings("unchecked")
    public List<Object> zapros1(){
        Session session = this.sessionFactory.getCurrentSession();
        List<Object> list = (List) session.createQuery("select new list(a.Marka, a.Model, count(s.Car)) " +
                "from Auto as a, Selling_auto as s where s.Car=a.Id_auto " +
                "group by a.Marka, a.Model, s.Car").list();
        for(Object a: list){
            logger.info(a.toString());
        }
        return list;
    }
}
