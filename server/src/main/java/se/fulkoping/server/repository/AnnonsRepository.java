package se.fulkoping.server.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import se.fulkoping.server.model.Annons;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AnnonsRepository {

    private final File file = new File("server/src/main/resources/annonser.json");
    private final ObjectMapper mapper = new ObjectMapper();
    private List<Annons> annonser = new ArrayList<>();
    private long nextId = 1;

    public AnnonsRepository() {
        load();
    }

    public List<Annons> findAll() {
        return annonser;
    }

    public void save(Annons annons) {
        annons.setId(nextId++);
        annonser.add(annons);
        saveToFile();
    }

    public void updatePrice(long id, String pinkod, double pris) {
        for (Annons a : annonser) {
            if (a.getId() == id && a.getPinkod().equals(pinkod)) {
                a.setPris(pris);
                saveToFile();
                return;
            }
        }
    }

    public void delete(long id, String pinkod) {
        annonser.removeIf(a ->
                a.getId() == id && a.getPinkod().equals(pinkod)
        );
        saveToFile();
    }

    private void saveToFile() {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, annonser);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void load() {
        try {
            if (file.exists()) {
                annonser = mapper.readValue(file, new TypeReference<>() {});
                if (!annonser.isEmpty()) {
                    nextId = annonser.get(annonser.size() - 1).getId() + 1;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}