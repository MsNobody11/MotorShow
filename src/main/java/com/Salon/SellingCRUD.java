package com.Salon;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.math.BigInteger;
import java.util.List;

public class SellingCRUD {
    @Test
    public void crudSelling() {
        Configuration configuration = new Configuration();
        configuration.configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        readSelling(session);
        createSelling(session);
        readSelling(session);
        //editSelling(session, 6,"2654-458632", "Афиногенов Игорь Васильевич", "15.02.2020","г.Нижний Новгород ул.Нартова д.14", "89200364895" );
        //readSelling(session);
        //removeSelling(session, 6);
       // readSelling(session);
        //getSel(session,  1);
        session.close();
    }


    private void readSelling(Session session) {
        List<Selling> sellingList = session.createQuery("SELECT s FROM Selling s").list();
        for (Selling s : sellingList) {
            System.out.println("List:" + s);
        }
    }
    private void createSelling(Session session) {
        Selling selling = new Selling();
        selling.setId(6);
        selling.setPasport("2654-458648");
        selling.setFIO("Нартов");
        selling.setDateOfBirth("01.05.2020");
        selling.setAddress("г.Нижний Новгород ул.Нартова д.14");
        selling.setTelef("89200364895");
        session.beginTransaction();
        session.save(selling);
        session.getTransaction().commit();
        System.out.println(" ");
        System.out.println("Create new selling:"+ selling);
        System.out.println(" ");
    }
    private void editSelling(Session session,int ID, String Pasport, String FIO, String DateOfBirth, String Address, String Telef){

        List<Selling> sellingList = session.createQuery("Select c from Selling c where id=" + "'"+ ID + "'").list();
        session.beginTransaction();

        for (Selling c : sellingList)
        {


            c.setPasport(Pasport);
            c.setFIO(FIO);
            c.setDateOfBirth(DateOfBirth);
            c.setAddress(Address);
            c.setTelef(Telef);
            session.update(c);
            System.out.println("EDIT selling with ID=" + Pasport + "WITH INFO" + c);

        }

        session.getTransaction().commit();
    }

    private void getSel(Session session, int ID) {
        List<Selling> sellingList = session.createQuery("Select c from  Selling c where  id=" + "'"+ ID + "'").list();
        for(Selling c : sellingList){
            System.out.println("");
            System.out.println("Selling FOUND by id: " + c);
            System.out.println(" ");
        }
    }

    private void removeSelling(Session session, int ID) {

        List<Selling> sellingList = session.createQuery("Select c from Selling c where id =" + "'" + ID + "'").list();
        session.beginTransaction();
        for (Selling c : sellingList) {
            session.delete(c);
        }
        session.getTransaction().commit();
        System.out.println(" ");
        System.out.println("DELETED selling with id=" + ID);
        System.out.println(" ");

    }


}
