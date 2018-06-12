package com.bhsuarez.week5.models;

import javax.persistence.*;

@Entity
@Table(name = "planet")
public class Planet {

    public Planet(){}

    @Id
    @Column(name = "PLANETID")
    private String planetId;

    @Column(name = "NAME")
    private String planetName;

    @Column(name = "RADIUS")
    private String planetRadius;

    @Column(name = "ATMOSPHERE")
    private String planetAtmosphere;

    public String getPlanetId() {
        return planetId;
    }

    public void setPlanetId(String id) {
        this.planetId = id;
    }

    public String getPlanetName() {
        return planetName;
    }

    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }

    public String getPlanetRadius() {
        return planetRadius;
    }

    public void setPlanetRadius(String planetRadius) {
        this.planetRadius = planetRadius;
    }

    public String getPlanetAtmosphere() {
        return planetAtmosphere;
    }

    public void setPlanetAtmosphere(String planetAtmosphere) {
        this.planetAtmosphere = planetAtmosphere;
    }

}
