package se.fulkoping.server.repository;

import se.fulkoping.server.model.Annons;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Repository som lagrar annonser i minnet
public class AnnonsRepository {

    private final List<Annons> annonser = new ArrayList<>();
    private long nextId = 1;

    // Hämta alla annonser
    public List<Annons> findAll() {
        return annonser;
    }

    // Hämta annons baserat på id
    public Optional<Annons> findById(long id) {
        return annonser.stream()
                .filter(a -> a.getId() == id)
                .findFirst();
    }

    // Spara ny annons (id sätts automatiskt)
    public void save(Annons annons) {
        annons.setId(nextId++);
        annonser.add(annons);
    }

    // Uppdatera pris om pinkod stämmer
    public boolean updatePrice(long id, String pinkod, double nyttPris) {
        Optional<Annons> annons = findById(id);

        if (annons.isPresent() && annons.get().getPinkod().equals(pinkod)) {
            annons.get().setPris(nyttPris);
            return true;
        }
        return false;
    }

    // Radera annons om pinkod stämmer
    public boolean delete(long id, String pinkod) {
        Optional<Annons> annons = findById(id);

        if (annons.isPresent() && annons.get().getPinkod().equals(pinkod)) {
            annonser.remove(annons.get());
            return true;
        }
        return false;
    }
}
