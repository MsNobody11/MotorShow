package com.join;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.logging.Logger;

@Repository
public class Join3DAO
{
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sf){this.sessionFactory = sf;}
    Logger logger = Logger.getLogger(String.valueOf(Join3DAO.class));

    //Запрос выводит информацию клиентах и проданных им автомобилях
    @SuppressWarnings("unchecked")
    public List<Object> zapros3(){
        Session session = this.sessionFactory.getCurrentSession();
        List<Object> list = (List) session.createQuery("select new list(s.FIO, a.Marka, a.Model) " +
                "from Selling as s, Auto as a, Selling_auto as sa where sa.Client=s.id and sa.Car=a.Id_auto " +
                "group by s.FIO, a.Marka, a.Model").list();
        for(Object a: list){
            logger.info(a.toString());
        }
        return list;
    }
}
