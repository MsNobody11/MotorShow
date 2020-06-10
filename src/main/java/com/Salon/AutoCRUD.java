package com.Salon;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.util.List;

public class AutoCRUD {
    @Test
    public void crudAuto() {
        Configuration configuration = new Configuration();
        configuration.configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        readAuto(session);
        createAuto(session);
        readAuto(session);
        editAuto(session, 7 , "Россия", "Lada","Kalina1", "седан", "бензин", "поперечное", "1.5л", "механика", "передний", 2, 130000 );
        readAuto(session);
        removeAuto(session, 7);
        readAuto(session);
        getAuto(session,  3);
        session.close();
    }


    private void readAuto(Session session) {
        List<Auto> autoList = session.createQuery("SELECT s FROM Auto s").list();
        for (Auto s : autoList) {
            System.out.println("List:" + s);
        }
    }
    private void createAuto(Session session) {
        Auto auto = new Auto();
        auto.setManufacturer("Россия");
        auto.setMarka("Lada");
        auto.setModel("Kalina");
        auto.setTypeBody("седан");
        auto.setTypeDvigatel("бензин");
        auto.setRaspDvig("поперечное");
        auto.setObDvig("1.5");
        auto.setTypeBox("механика");
        auto.setTypePrivod("передний");
        auto.setCompl(1);
        auto.setPrice(120000);
        session.beginTransaction();
        session.save(auto);
        session.getTransaction().commit();
        System.out.println(" ");
        System.out.println("Create new auto:"+ auto);
        System.out.println(" ");
    }
    private void editAuto(Session session,Integer Id_auto, String Manufacturer, String Marka, String Model, String TypeBody, String TypeDvigatel, String RaspDvig, String ObDvig, String TypeBox, String TypePrivod, Integer Compl, Integer Price){

        List<Auto> autoList = session.createQuery("Select c from Auto c where id_auto=" + "'"+ Id_auto + "'").list();
        session.beginTransaction();

        for (Auto c : autoList)
        {
            c.setId(Id_auto);
            c.setManufacturer(Manufacturer);
            c.setMarka(Marka);
            c.setModel(Model);
            c.setTypeBody(TypeBody);
            c.setTypeDvigatel(TypeDvigatel);
            c.setRaspDvig(RaspDvig);
            c.setObDvig(ObDvig);
            c.setTypeBox(TypeBox);
            c.setTypePrivod(TypePrivod);
            c.setCompl(Compl);
            c.setPrice(Price);
            session.update(c);

            System.out.println("EDIT auto with ID=" + Id_auto + "WITH INFO" + c);
        }
        session.getTransaction().commit();
    }

    private void getAuto(Session session, Integer Id_auto) {
        List<Auto> autoList = session.createQuery("Select c from  Auto c where  Id_auto=" + "'"+ Id_auto + "'").list();
        for(Auto c : autoList){
            System.out.println("");
            System.out.println("Auto FOUND by Id_auto: " + c);
            System.out.println(" ");
        }
    }

    private void removeAuto(Session session, Integer Id_auto) {

        List<Auto> autoList = session.createQuery("Select c from Auto c where id_auto =" + "'" + Id_auto + "'").list();
        session.beginTransaction();
        for (Auto c : autoList) {
            session.delete(c);
        }
        session.getTransaction().commit();
        System.out.println(" ");
        System.out.println("DELETED auto with id_auto=" + Id_auto);
        System.out.println(" ");

    }
}
