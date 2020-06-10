package com.Salon;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.util.List;

public class ComplectCRUD {
    @Test
    public void crudCompl() {
        Configuration configuration = new Configuration();
        configuration.configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        readCompl(session);
        createCompl(session);
        readCompl(session);
        editCompl(session, 4, "что-то", 2 );
        readCompl(session);
        removeCompl(session, 4);
        readCompl(session);
        getCompl(session,  3);
        session.close();
    }


    private void readCompl(Session session) {
        List<Complect> complectList = session.createQuery("SELECT s FROM Complect s").list();
        for (Complect s : complectList) {
            System.out.println("List:" + s);
        }
    }
    private void createCompl(Session session) {
        Complect compl = new Complect();
        compl.setKodCompl(4);
        compl.setName("fiwbf");
        compl.setSostav(7);
        session.beginTransaction();
        session.save(compl);
        session.getTransaction().commit();
        System.out.println(" ");
        System.out.println("Create new complect:"+ compl);
        System.out.println(" ");
    }
    private void editCompl(Session session, Integer KodCompl, String Name, Integer Sostav){

        List<Complect> complectList = session.createQuery("Select c from Complect c where kodCompl=" + "'"+ KodCompl + "'").list();
        session.beginTransaction();

        for (Complect c : complectList)
        {

            c.setKodCompl(KodCompl);
            c.setName(Name);
            c.setSostav(Sostav);
            session.update(c);

            System.out.println("EDIT complect with KodCompl =" + KodCompl + "WITH INFO" + c);

        }

        session.getTransaction().commit();
    }

    private void getCompl(Session session, Integer KodCompl) {
        List<Complect> complectList = session.createQuery("Select c from  Complect c where  kodCompl=" + "'"+ KodCompl + "'").list();
        for(Complect c : complectList){
            System.out.println("");
            System.out.println("Complect FOUND by kodCompl: " + c);
            System.out.println(" ");
        }
    }

    private void removeCompl(Session session, Integer KodCompl) {

        List<Complect> complectList = session.createQuery("Select c from Complect c where kodCompl =" + "'" + KodCompl + "'").list();
        session.beginTransaction();
        for (Complect c : complectList) {
            session.delete(c);
        }
        session.getTransaction().commit();
        System.out.println(" ");
        System.out.println("DELETED complect with kodCompl=" + KodCompl);
        System.out.println(" ");

    }

}
