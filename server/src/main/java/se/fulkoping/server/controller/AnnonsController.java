package se.fulkoping.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class AnnonsController {

    @GetMapping("/annonser")
    public List<Map<String, Object>> getAnnonser() {
        return List.of(
                Map.of(
                        "id", 1,
                        "title", "iPhone 14 – bra skick",
                        "price", 5000
                )
        );
    }
}
