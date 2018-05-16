package com.bhsuarez.week5;

import java.util.List;
import java.util.Iterator;

import com.bhsuarez.week5.models.Planet;
import com.bhsuarez.week5.models.Starship;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.HibernateException;

public class DataStore {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            /*
            String dbName = System.getenv("RDS_DB_NAME");
            String userName = System.getenv("RDS_USERNAME");
            String password = System.getenv("RDS_PASSWORD");
            String hostname = System.getenv("RDS_HOSTNAME");
            String port = System.getenv("RDS_PORT");
            String jdbcUrl = "jdbc:oracle:thin:@" + hostname + ":" + port + ":" + dbName;
            */
            System.out.println("test");

            // Create the SessionFactory from hibernate.cfg.xml
            Configuration cfg = new Configuration();
            cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file
            return cfg.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static List<Planet> listPlanets( ) {
        System.out.print("listPlanets()");

        Session session = getSessionFactory().openSession();


        try {

            List planets = session.createQuery("FROM Planet").list();
            for (Iterator iterator = planets.iterator(); iterator.hasNext(); ) {
                Planet planet = (Planet) iterator.next();
                System.out.print("Name: " + planet.getPlanetName());
                System.out.print("  Radius: " + planet.getPlanetRadius());
                System.out.print("  Atmosphere: " + planet.getPlanetAtmosphere());
            }

            return planets;
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }


    public static Starship findStarshipById(String starshipId) {
        Session session = getSessionFactory().openSession();
        try {
            return (Starship) session.get(Starship.class, starshipId);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }
}