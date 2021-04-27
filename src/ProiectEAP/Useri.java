package ProiectEAP;

public class Useri {
    private String nume;
    private String prenume;
    private String email;
    private String parola;
    private String card;
    private String nr_card;

    public Useri(String nume, String prenume, String email, String parola, String card, String nr_card) {
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.parola = parola;
        this.card = card;
        this.nr_card = nr_card;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getEmail() {
        return email;
    }

    public String getParola() {
        return parola;
    }

    public String getCard() {
        return card;
    }

    public String getNr_card() {
        return nr_card;
    }

    @Override
    public String toString() {
        return nume+","+prenume+","+email+","+parola+","+card+","+nr_card+",";
    }
}

