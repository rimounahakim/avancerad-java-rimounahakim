package se.fulkoping.server.repository;
import se.fulkoping.server.model.Annons;

import java.util.ArrayList;
import java.util.List;

// Enkel repository som sparar annonser i minnet
public class AnnonsRepository {

    // Lista som fungerar som "databas i minnet"
    private final List<Annons> annonser = new ArrayList<>();

    // Hämta alla annonser
    public List<Annons> findAll() {
        return annonser;
    }

    // Spara en ny annons
    public void save(Annons annons) {
        annonser.add(annons);
    }
}
