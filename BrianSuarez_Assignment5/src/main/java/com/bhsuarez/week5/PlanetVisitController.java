package com.bhsuarez.week5;

import com.bhsuarez.week5.models.Planetvisit;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlanetVisitController {

    @RequestMapping("/visit")
    public List<Planetvisit> planetVisits() {
        return DataStore.listPlanetVisits();
    }

    @PostMapping(value="/visit", consumes = { MediaType.APPLICATION_JSON_VALUE })
    public Planetvisit addPlanetVisit(@RequestBody Planetvisit planetVisitToAdd) {
        return DataStore.addPlanetVisit(planetVisitToAdd);
    }
}
