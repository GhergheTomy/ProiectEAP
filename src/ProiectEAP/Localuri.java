package ProiectEAP;

public class Localuri {
    private final String nume;
    private String locatie;
    private String specific;
    private float media;

    public Localuri(String nume, String locatie, String specific, float media) {
        this.nume = nume;
        this.locatie = locatie;
        this.specific = specific;
        this.media = media;
    }

    public String getNume() {
        return nume;
    }

    public String getLocatie() {
        return locatie;
    }

    public String getSpecific() {
        return specific;
    }

    public float getMedia() {
        return media;
    }

    public void setMedia(float media) {
        this.media = media;
    }
}
