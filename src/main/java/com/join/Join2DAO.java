package com.join;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.logging.Logger;

@Repository
public class Join2DAO
{
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sf){this.sessionFactory = sf;}
    Logger logger = Logger.getLogger(String.valueOf(Join2DAO.class));

//Запрос выводит информацию об автомобилях, цена которых выше средней
    @SuppressWarnings("unchecked")
    public List<Object> zapros2(){
        Session session = this.sessionFactory.getCurrentSession();
        List<Object> list = (List) session.createQuery("SELECT new list(s.Manufacturer, s.Marka, s.Model, s.TypeBody, s.TypeDvigatel, " +
                "s.RaspDvig, s.ObDvig, s.TypeBox, s.TypePrivod, s.Compl, s.Price) " +
                "from Auto s where s.Price > (Select AVG(s.Price) from Auto s)").list();
        for(Object a: list){
            logger.info(a.toString());
        }
        return list;
    }
}
