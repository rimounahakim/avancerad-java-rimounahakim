package se.fulkoping.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import se.fulkoping.server.repository.AnnonsRepository;

// Enkel controller för att testa om servern fungerar rätt
@RestController
public class TestController {

    // Repository för att hantera annonser (lagras i minnet)
    private final AnnonsRepository repository = new AnnonsRepository();

    // Test-endpoint för att kontrollera att servern svarar
    @GetMapping("/test")
    public String test() {
        return "Servern fungerar!";
    }
}
