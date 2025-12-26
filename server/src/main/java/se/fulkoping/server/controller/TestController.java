package se.fulkoping.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import se.fulkoping.server.repository.AnnonsRepository;
import se.fulkoping.server.model.Annons;

import java.util.List;

// Controller som hanterar annonser via REST
@RestController
public class TestController {

    // Repository som lagrar annonser i minnet
    private final AnnonsRepository repository = new AnnonsRepository();

    // Test-endpoint
    @GetMapping("/test")
    public String test() {
        return "Servern fungerar!";
    }

    // Hämta alla annonser
    @GetMapping("/annons")
    public List<Annons> getAllAnnons() {
        return repository.findAll();
    }

    // Skapa ny annons (pinkod skickas in men returneras aldrig)
    @PostMapping("/annons")
    public String addAnnons(@RequestBody Annons annons) {
        repository.save(annons);
        return "Annons sparad!";
    }

    // Ändra pris på annons (kräver korrekt pinkod)
    @PutMapping("/annons/price")
    public String updatePrice(
            @RequestParam long id,
            @RequestParam String pinkod,
            @RequestParam double pris) {

        boolean updated = repository.updatePrice(id, pinkod, pris);
        return updated ? "Pris uppdaterat!" : "Fel id eller pinkod";
    }

    // Radera annons (kräver korrekt pinkod)
    @DeleteMapping("/annons")
    public String deleteAnnons(
            @RequestParam long id,
            @RequestParam String pinkod) {

        boolean deleted = repository.delete(id, pinkod);
        return deleted ? "Annons raderad!" : "Fel id eller pinkod";
    }
}
