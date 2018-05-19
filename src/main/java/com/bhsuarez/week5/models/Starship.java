package com.bhsuarez.week5.models;

import javax.persistence.*;

@Entity
@Table(name = "starship")
public class Starship {


    public Starship(){}

    @Id
    @Column(name = "STARSHIPID")
    private String starshipId;

    @Column(name = "NAME")
    private String starshipName;

    @Column(name = "CREWSIZE")
    private String starshipCrewSize;

    @Column(name = "SHIPCLASS")
    private String starshipClass;

    @Column(name = "LAUNCHSTARDATE")
    private String launchStarDate;

    public String getStarshipId() {
        return starshipId;
    }

    public void setStarshipId(String starshipId) {
        this.starshipId = starshipId;
    }

    public String getStarshipName() {
        return starshipName;
    }

    public void setStarshipName(String starshipName) {
        this.starshipName = starshipName;
    }

    public String getStarshipCrewSize() {
        return starshipCrewSize;
    }

    public void setStarshipCrewSize(String starshipCrewSize) {
        this.starshipCrewSize = starshipCrewSize;
    }

    public String getStarshipClass() {
        return starshipClass;
    }

    public void setStarshipClass(String starshipClass) {
        this.starshipClass = starshipClass;
    }

    public String getLaunchStarDate() {
        return launchStarDate;
    }

    public void setLaunchStarDate(String launchStarDate) {
        this.launchStarDate = launchStarDate;
    }

}
