package com.Salon;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.util.List;

public class SostavCRUD {

    @Test
    public void crudSostavCompl() {
        Configuration configuration = new Configuration();
        configuration.configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        readSostav(session);
        createSostav(session);
        readSostav(session);
        editSostav(session, 13, "gflerguehi" );
        readSostav(session);
        removeSostav(session, 13);
        readSostav(session);
        getSostav(session,  5);
        session.close();
    }
    private void readSostav(Session session) {
        List<SostavCompl> sostavComplList = session.createQuery("SELECT s FROM SostavCompl s").list();
        for (SostavCompl s : sostavComplList) {
            System.out.println("List:" + s);
        }
    }
    private void createSostav(Session session) {
        SostavCompl sostavCompl = new SostavCompl();

        sostavCompl.setName("что-то");

        session.beginTransaction();
        session.save(sostavCompl);
        session.getTransaction().commit();
        System.out.println(" ");
        System.out.println("Create new sostavCompl:"+ sostavCompl);
        System.out.println(" ");
    }
    private void editSostav(Session session, Integer KodElement, String NameElement){

        List<SostavCompl> sostavComplList = session.createQuery("Select c from SostavCompl c where kodelement=" + "'"+ KodElement + "'").list();
        session.beginTransaction();

        for (SostavCompl c : sostavComplList)
        {

            c.setKod(KodElement);
            c.setName(NameElement);
            session.update(c);
            System.out.println("EDIT sostavcompl with kodelement=" + KodElement + "WITH INFO" + c);

        }

        session.getTransaction().commit();
    }

    private void getSostav(Session session, Integer KodElement) {
        List<SostavCompl> sostavComplList = session.createQuery("Select c from  SostavCompl c where  kodelement=" + "'"+ KodElement + "'").list();
        for(SostavCompl c : sostavComplList){
            System.out.println("");
            System.out.println("SostavCompl FOUND by kodelement: " + c);
            System.out.println(" ");
        }
    }

    private void removeSostav(Session session, Integer KodElement) {

        List<SostavCompl> sostavComplList = session.createQuery("Select c from SostavCompl c where kodelement =" + "'" + KodElement + "'").list();
        session.beginTransaction();
        for (SostavCompl c : sostavComplList) {
            session.delete(c);
        }
        session.getTransaction().commit();
        System.out.println(" ");
        System.out.println("DELETED sostavcompl with kodelement=" + KodElement);
        System.out.println(" ");

    }



}
