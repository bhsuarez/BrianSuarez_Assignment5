package com.bhsuarez.week5;

import java.util.List;

import com.bhsuarez.week5.models.Planet;
import com.bhsuarez.week5.models.Planetvisit;
import com.bhsuarez.week5.models.Starship;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.HibernateException;

public class DataStore {

    private static final SessionFactory sessionFactory = buildSessionFactory();


    // Builds session for DataStore
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

    // Returns sessionFactory object
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    // Returns list of Planets collection
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

    // Updates planet by planetID
    public static Planet updatePlanet(String planetId, Planet planetInput){

        Session session = getSessionFactory().openSession();
        Transaction transaction = null;

        try{
            transaction = session.beginTransaction();
            Planet existing = findPlanetById(planetId);
            existing.setPlanetAtmosphere(planetInput.getPlanetAtmosphere());
            existing.setPlanetName(planetInput.getPlanetName());
            existing.setPlanetRadius(planetInput.getPlanetRadius());
            System.out.println("Planet "+planetId+" has been updated");
            session.update(existing);
            transaction.commit();

            return existing;

        }catch (HibernateException e) {
            if(transaction != null){ transaction.rollback(); }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    // Adds new planet
    public static Planet addPlanet(Planet planetInput){

        Session session = getSessionFactory().openSession();
        Transaction transaction = null;

        try{
            transaction = session.beginTransaction();
            Planet existing = new Planet();
            existing.setPlanetId(planetInput.getPlanetId());
            existing.setPlanetAtmosphere(planetInput.getPlanetAtmosphere());
            existing.setPlanetName(planetInput.getPlanetName());
            existing.setPlanetRadius(planetInput.getPlanetRadius());
            System.out.println("Planet "+existing.getPlanetId()+" has been added");
            session.save(existing);
            transaction.commit();

            return existing;

        }catch (HibernateException e) {
            if(transaction != null){ transaction.rollback(); }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    // Deletes planet by planetId
    public static Planet deletePlanet(String planetId){

        Session session = getSessionFactory().openSession();
        Transaction transaction = null;

        try{
            transaction = session.beginTransaction();
            Planet existing = new Planet();
            existing.setPlanetId(planetId);
            session.delete(existing);
            System.out.println("Planet "+planetId+" has been deleted");
            transaction.commit();

            return existing;

        }catch (HibernateException e) {
            if(transaction != null){ transaction.rollback(); }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    // Updates starship by starshipID
    public static Starship updateStarship(String starShipId, Starship starshipInput){

        Session session = getSessionFactory().openSession();
        Transaction transaction = null;

        try{
            transaction = session.beginTransaction();
            Starship existing = findStarshipById(starShipId);
            existing.setStarshipName(starshipInput.getStarshipName());
            existing.setStarshipCrewSize(starshipInput.getStarshipCrewSize());
            existing.setStarshipClass(starshipInput.getStarshipClass());
            existing.setLaunchStarDate(starshipInput.getLaunchStarDate());
            System.out.println("Starship "+starShipId+" has been updated");
            session.update(existing);
            transaction.commit();

            return existing;

        }catch (HibernateException e) {
            if(transaction != null){ transaction.rollback(); }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    // Adds new starship
    public static Starship addStarship(Starship starshipInput){

        Session session = getSessionFactory().openSession();
        Transaction transaction = null;

        try{
            transaction = session.beginTransaction();
            Starship existing = new Starship();
            existing.setStarshipId(starshipInput.getStarshipId());
            existing.setStarshipName(starshipInput.getStarshipName());
            existing.setStarshipCrewSize(starshipInput.getStarshipCrewSize());
            existing.setStarshipClass(starshipInput.getStarshipClass());
            existing.setLaunchStarDate(starshipInput.getLaunchStarDate());
            System.out.println("Starship "+existing.getStarshipId()+" has been added");
            session.save(existing);
            transaction.commit();

            return existing;

        }catch (HibernateException e) {
            if(transaction != null){ transaction.rollback(); }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    // Deletes starship by starshipId
    public static Starship deleteStarship(String starshipId){

        Session session = getSessionFactory().openSession();
        Transaction transaction = null;

        try{
            transaction = session.beginTransaction();
            Starship existing = new Starship();
            existing.setStarshipId(starshipId);

            session.delete(existing);
            System.out.println("Planet "+starshipId+" has been deleted");
            transaction.commit();

            return existing;

        }catch (HibernateException e) {
            if(transaction != null){ transaction.rollback(); }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    // Returns list of Starship collection
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

    // Returns list of Planetvisit collection
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

    // Adds new planetvisit
    public static Planetvisit addPlanetVisit(Planetvisit planetVisitInput){

        Session session = getSessionFactory().openSession();
        Transaction transaction = null;

        try{
            transaction = session.beginTransaction();
            Planetvisit existing = new Planetvisit();
            existing.setPlanetId(planetVisitInput.getPlanetId());
            existing.setStarshipID(planetVisitInput.getStarshipID());
            existing.setArrivalStarDate(planetVisitInput.getArrivalStarDate());
            existing.setDepartureStarDate(planetVisitInput.getDepartureStarDate());
            System.out.println("Planet Visit "+existing.getPlanetId()+" has been added");
            session.save(existing);
            transaction.commit();

            return existing;

        }catch (HibernateException e) {
            if(transaction != null){ transaction.rollback(); }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    // Returns starship collection elements by starshipID
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

    // Returns planet collection elements by planetID
    public static Planet findPlanetById(String planetId) {
        Session session = getSessionFactory().openSession();
        try {
            return (Planet) session.get(Planet.class, planetId);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }
}