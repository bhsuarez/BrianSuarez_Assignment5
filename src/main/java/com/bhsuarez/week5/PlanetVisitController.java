package com.bhsuarez.week5;

import com.bhsuarez.week5.models.Planetvisit;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlanetVisitController {

    @RequestMapping("/planetvisit")
    public List<Planetvisit> planetVisits() {
        return DataStore.listPlanetVisits();
    }
}
