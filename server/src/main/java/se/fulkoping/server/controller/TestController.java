package se.fulkoping.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import se.fulkoping.server.repository.AnnonsRepository;
import se.fulkoping.server.model.Annons;

import java.util.List;

// Enkel controller för att testa och hantera annonser
@RestController
public class TestController {

    // Repository som lagrar annonser i minnet
    private final AnnonsRepository repository = new AnnonsRepository();

    // Test-endpoint för att se om servern fungerar
    @GetMapping("/test")
    public String test() {
        return "Servern fungerar!";
    }

    // Endpoint för att hämta alla annonser
    @GetMapping("/annons")
    public List<Annons> getAllAnnons() {
        return repository.findAll();
    }

    // Endpoint för att lägga till en ny annons
    @PostMapping("/annons")
    public String addAnnons(@RequestBody Annons annons) {
        repository.save(annons);
        return "Annons sparad!";
    }
}
