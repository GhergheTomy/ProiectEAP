package ProiectEAP;

public class Meniu {
    private String nume_mancare;
    private String descriere;
    private boolean disponibilitate;
    private int pret;
    private boolean reduceri;
    private Localuri localuri;

    public Meniu(String nume_mancare, String descriere, boolean disponibilitate, int pret, boolean reduceri, Localuri localuri) {
        this.nume_mancare = nume_mancare;
        this.descriere = descriere;
        this.disponibilitate = disponibilitate;
        this.pret = pret;
        this.reduceri = reduceri;
        this.localuri = localuri;
    }

    public String getDescriere() {
        return descriere;
    }

    public boolean isDisponibilitate() {
        return disponibilitate;
    }

    public void setDisponibilitate(boolean disponibilitate) {
        this.disponibilitate = disponibilitate;
    }

    public boolean isReduceri() {
        return reduceri;
    }

    public String getNume_mancare() {
        return nume_mancare;
    }

    public int getPret() {
        return pret;
    }

    public void setReduceri(boolean reduceri) {
        this.reduceri = reduceri;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }
}

