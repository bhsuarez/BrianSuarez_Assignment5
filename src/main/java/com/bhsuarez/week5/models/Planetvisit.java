package com.bhsuarez.week5.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "planetvisit", uniqueConstraints = @UniqueConstraint(columnNames = {"starshipID", "planetID", "arrivalstardate"}))
public class Planetvisit implements Serializable {

    public Planetvisit(){}

    @Id
    @Column(name = "PLANETID")
    private String planetId;

    @Id
    @Column(name = "STARSHIPID")
    private String starshipID;

    @Id
    @Column(name = "ARRIVALSTARDATE")
    private String arrivalStarDate;

    @Column(name = "DEPARTURESTARDATE")
    private String departureStarDate;

    public String getPlanetId() {
        return planetId;
    }

    public void setPlanetId(String planetId) {
        this.planetId = planetId;
    }

    public String getStarshipID() {
        return starshipID;
    }

    public void setStarshipID(String starshipID) {
        this.starshipID = starshipID;
    }

    public String getArrivalStarDate() {
        return arrivalStarDate;
    }

    public void setArrivalStarDate(String arrivalStarDate) {
        this.arrivalStarDate = arrivalStarDate;
    }

    public String getDepartureStarDate() {
        return departureStarDate;
    }

    public void setDepartureStarDate(String departureStarDate) {
        this.departureStarDate = departureStarDate;
    }

}