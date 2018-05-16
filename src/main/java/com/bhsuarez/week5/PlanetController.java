package com.bhsuarez.week5;


import com.bhsuarez.week5.models.Planet;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlanetController {

    @RequestMapping("/planet")
    public List<Planet> planet() {
        return DataStore.listPlanets();
    }

    @GetMapping("/planet/{planetId}")
    public Planet getPlanetById(@PathVariable(value = "planetId") String planetId) {
        return DataStore.findPlanetById(planetId);
    }
}