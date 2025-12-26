package se.fulkoping.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Enkel controller för att testa om servern fungerar rätt
@RestController
public class TestController {

    // Test-endpoint för att se om servern svarar
    @GetMapping("/test")
    public String test() {
        return "Servern fungerar!";
    }
}
