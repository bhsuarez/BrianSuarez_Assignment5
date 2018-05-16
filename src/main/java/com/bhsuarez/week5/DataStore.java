package com.bhsuarez.week5;

import java.util.List;

import com.bhsuarez.week5.models.Planet;
import com.bhsuarez.week5.models.Planetvisit;
import com.bhsuarez.week5.models.Starship;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.HibernateException;

public class DataStore {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {

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
            return planets;
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public static List<Starship> listStarships( ) {
        System.out.print("listStarships()");

        Session session = getSessionFactory().openSession();

        try {
            List starships = session.createQuery("FROM Starship").list();
            return starships;
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public static List<Planetvisit> listPlanetVisits( ) {
        System.out.print("listPlanetVisits()");

        Session session = getSessionFactory().openSession();

        try {
            List planetvisits = session.createQuery("FROM Planetvisit").list();
            return planetvisits;
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