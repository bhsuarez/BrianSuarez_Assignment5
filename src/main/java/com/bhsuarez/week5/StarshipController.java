package com.bhsuarez.week5;

import com.bhsuarez.week5.models.Starship;
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


}