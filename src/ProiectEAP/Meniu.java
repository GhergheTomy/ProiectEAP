package ProiectEAP;

public class Meniu {
    private String nume_mancare;
    private String descriere;
    private boolean disponibilitate;
    private int pret;
    private boolean reduceri;
//    private Localuri localuri;
//     O sa o folosesc in momentul in care o saa fac cu lucru la o baza de date respectiv din fisier. In clipa de fata nu am ajuns sa ma descurc asa bine :(
        public Meniu(String nume_mancare, String descriere, boolean disponibilitate, int pret, boolean reduceri) {
        this.nume_mancare = nume_mancare;
        this.descriere = descriere;
        this.disponibilitate = disponibilitate;
        this.pret = pret;
        this.reduceri = reduceri;
//        this.localuri = localuri;
    }

    public String getNume_mancare() {
        return nume_mancare;
    }

    public String getDescriere() {
        return descriere;
    }

    public boolean isDisponibilitate() {
        return disponibilitate;
    }

    public int getPret() {
        return pret;
    }

    public boolean isReduceri() {
        return reduceri;
    }

    public void setNume_mancare(String nume_mancare) {
        this.nume_mancare = nume_mancare;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public void setDisponibilitate(boolean disponibilitate) {
        this.disponibilitate = disponibilitate;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }

    public void setReduceri(boolean reduceri) {
        this.reduceri = reduceri;
    }
}

