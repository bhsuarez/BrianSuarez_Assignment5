package com.bhsuarez.week5;

import com.bhsuarez.week5.models.Starship;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class StarshipController {

    @RequestMapping("/starship")
    public List<Starship> starship() {
        return DataStore.listStarships();
    }

    @GetMapping("/starship/{starshipId}")
    public Starship getStarshipById(@PathVariable(value = "starshipId") String starshipId) {
        return DataStore.findStarshipById(starshipId);
    }

    @PutMapping(value = "/starship/{starshipId}", consumes = { MediaType.APPLICATION_JSON_VALUE })
    public Starship updateStarship(@PathVariable(value = "starshipId") String starshipId, @RequestBody Starship starship) {
        return DataStore.updateStarship(starshipId, starship);
    }

    @PostMapping(value = "/starship")
    public Starship addStarship(@RequestBody Starship starship) {
        return DataStore.addStarship(starship);
    }

    @DeleteMapping(value = "/starship/{starshipId}")
    public Starship deleteStarship(@PathVariable(value = "starshipId") String starshipId) {
        return DataStore.deleteStarship(starshipId);
    }



}