package se.fulkoping.server.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/annonser")
public class AnnonsController {

    private List<Map<String, Object>> annonser = new ArrayList<>();
    private int nextId = 1;

    public AnnonsController() {
        Map<String, Object> annons = new HashMap<>();
        annons.put("id", nextId++);
        annons.put("title", "iPhone 14 - bra skick");
        annons.put("price", 5000);
        annonser.add(annons);
    }

    @GetMapping
    public List<Map<String, Object>> getAll() {
        return annonser;
    }

    @GetMapping("/{id}")
    public Map<String, Object> getById(@PathVariable int id) {
        return annonser.stream()
                .filter(a -> (int) a.get("id") == id)
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    public Map<String, Object> create(@RequestBody Map<String, Object> body) {
        body.put("id", nextId++);
        annonser.add(body);
        return body;
    }
}