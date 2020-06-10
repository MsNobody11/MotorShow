package com.Salon;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.util.List;

public class Selling_autoCRUD {
    @Test
    public void crudSelling_Auto() {
        Configuration configuration = new Configuration();
        configuration.configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        readSelling_Auto(session);
        createSelling_Auto(session);
        readSelling_Auto(session);
        editSelling_Auto(session, 6, 5 );
        readSelling_Auto(session);
        removeSelling_Auto(session, 6);
        readSelling_Auto(session);
        getSelling_Auto(session,  4);
        session.close();
    }


    private void readSelling_Auto(Session session) {
        List<Selling_auto> sellingAutoList = session.createQuery("SELECT s FROM Selling_auto s").list();
        for (Selling_auto s : sellingAutoList) {
            System.out.println("List:" + s);
        }
    }
    private void createSelling_Auto(Session session) {
        Selling_auto selling_auto = new Selling_auto();
        selling_auto.setClient(6);
        selling_auto.setCar(3);

        session.beginTransaction();
        session.save(selling_auto);
        session.getTransaction().commit();
        System.out.println(" ");
        System.out.println("Create new selling_auto:"+ selling_auto);
        System.out.println(" ");
    }
    private void editSelling_Auto(Session session, Integer Client, Integer Car){

        List<Selling_auto> sellingAutoList = session.createQuery("Select c from Selling_auto c where client=" + "'"+ Client + "'").list();
        session.beginTransaction();

        for (Selling_auto c : sellingAutoList)
        {

            c.setClient(Client);
            c.setCar(Car);
            session.update(c);

            System.out.println("EDIT selling_auto with ID=" + Client + "WITH INFO" + c);

        }

        session.getTransaction().commit();
    }

    private void getSelling_Auto(Session session, Integer Client) {
        List<Selling_auto> sellingAutoList = session.createQuery("Select s from  Selling_auto s where  client=" + "'"+ Client + "'").list();
        for(Selling_auto s : sellingAutoList){
            System.out.println("");
            System.out.println("Selling_auto FOUND by client: " + s);
            System.out.println(" ");
        }
    }

    private void removeSelling_Auto(Session session, Integer Client) {

        List<Selling_auto> sellingAutoList = session.createQuery("Select c from Selling_auto c where client =" + "'" + Client + "'").list();
        session.beginTransaction();
        for (Selling_auto c : sellingAutoList) {
            session.delete(c);
        }
        session.getTransaction().commit();
        System.out.println(" ");
        System.out.println("DELETED selling_aauto with client=" + Client);
        System.out.println(" ");

    }
}
