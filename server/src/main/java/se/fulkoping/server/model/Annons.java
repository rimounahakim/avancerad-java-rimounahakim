package se.fulkoping.server.model;

// Denna klass representerar en annons på köp- och sälj-sidan
public class Annons {

    // Unikt id för annonsen
    private long id;

    // Ämnesrad / titel för annonsen
    private String rubrik;

    // Information om säljaren (namn, e-post eller telefon)
    private String saljare;

    // Beskrivning av varan
    private String beskrivning;

    // Pris på varan
    private double pris;

    // Pinkod som krävs för att ändra eller radera annonsen
    // Denna skickas aldrig tillbaka till klienten
    private String pinkod;

    // Getter och setter för id
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    // Getter och setter för rubrik
    public String getRubrik() {
        return rubrik;
    }

    public void setRubrik(String rubrik) {
        this.rubrik = rubrik;
    }

    // Getter och setter för säljare
    public String getSaljare() {
        return saljare;
    }

    public void setSaljare(String saljare) {
        this.saljare = saljare;
    }

    // Getter och setter för beskrivning
    public String getBeskrivning() {
        return beskrivning;
    }

    public void setBeskrivning(String beskrivning) {
        this.beskrivning = beskrivning;
    }

    // Getter och setter för pris
    public double getPris() {
        return pris;
    }

    public void setPris(double pris) {
        this.pris = pris;
    }

    // Getter och setter för pinkod
    public String getPinkod() {
        return pinkod;
    }

    public void setPinkod(String pinkod) {
        this.pinkod = pinkod;
    }
}
