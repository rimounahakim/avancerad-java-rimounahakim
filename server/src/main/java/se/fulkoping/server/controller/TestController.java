package se.fulkoping.server.controller;

import org.springframework.web.bind.annotation.*;
import se.fulkoping.server.model.Annons;
import se.fulkoping.server.repository.AnnonsRepository;

import java.util.List;

@RestController
@RequestMapping("/annons")
public class TestController {

    private final AnnonsRepository repository = new AnnonsRepository();

    @GetMapping
    public List<Annons> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public void create(@RequestBody Annons annons) {
        repository.save(annons);
    }

    @PutMapping("/{id}")
    public void updatePrice(
            @PathVariable long id,
            @RequestParam String pinkod,
            @RequestParam double pris
    ) {
        repository.updatePrice(id, pinkod, pris);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable long id,
            @RequestParam String pinkod
    ) {
        repository.delete(id, pinkod);
    }
}