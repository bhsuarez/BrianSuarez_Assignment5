package com.bhsuarez.week5;

import com.bhsuarez.week5.models.Starship;
import org.springframework.web.bind.annotation.*;

@RestController
public class StarshipController {

    @GetMapping("/starship/{starshipId}")
    public Starship getStarshipById(@PathVariable(value = "starshipId") String starshipId) {
        return DataStore.findStarshipById(starshipId);
    }
}