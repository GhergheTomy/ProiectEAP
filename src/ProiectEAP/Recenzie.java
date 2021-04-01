package ProiectEAP;

public class Recenzie {
    private final int nr_rating;
    private final int nota;
    private final String comentariu;
//    private Localuri localuri;
//    private Useri useri;
//    Motivul comentarii acestor linii l-am mentionat in Meniu :(

    public Recenzie(int nr_rating, int nota, String comentariu) {
        this.nr_rating = nr_rating;
        this.nota = nota;
        this.comentariu = comentariu;
//        this.localuri = localuri;
//        this.useri = useri;
    }

    public int getNr_rating() {
        return nr_rating;
    }

    public int getNota() {
        return nota;
    }

//    public Localuri getLocaluri() {
//        return localuri;
//    }

    public String getComentariu() {
        return comentariu;
    }

//    public Useri getUseri() {
//        return useri;
//    }
}
