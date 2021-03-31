package ProiectEAP;

import java.util.Vector;

public class Servicii {
    //    Comenzi
    private static Vector<Comenzi> comanda = new Vector<Comenzi>();

    public static Vector<Comenzi> getComenzi() {
        return comanda;
    }

    public static void adaugaComenzi( Useri useri, int nr_comanda, Meniu meniu, Soferi soferi) {

        comanda.add(new Comenzi( useri, nr_comanda, meniu, soferi));
    }

    //    Soferi
    private static Vector<Soferi> sofer = new Vector<Soferi>();

    public static Vector<Soferi> getSoferi() {
        return sofer;
    }

    public static void adaugaSoferi(String nume, boolean POS, String vehicul, Localuri localuri) {

        sofer.add(new Soferi(nume, POS, vehicul, localuri));
    }

    //    Recenzie
    private static Vector<Recenzie> recenzie = new Vector<Recenzie>();

    public static Vector<Recenzie> getRecenzie() {
        return recenzie;
    }

    public static void adaugaRecenzie(final int nr_rating, final int nota, final String comentariu, Localuri localuri, Useri useri) {

        recenzie.add(new Recenzie(nr_rating, nota, comentariu, localuri, useri));
    }

    //Vaucher
    private static Vector<Vaucher> vaucher = new Vector<Vaucher>();

    public static Vector<Vaucher> getVaucher() {
        return vaucher;
    }

    public static void adaugaVaucher(int cod, String descriere) {

        vaucher.add(new Vaucher(cod, descriere));
    }

    //Useri
    private static Vector<Useri> user = new Vector<Useri>();

    public static Vector<Useri> getUseri() {
        return user;
    }

    public static void adaugaUseri(String nume, String prenume, String email, String parola, String card, String nr_card) {

        user.add(new Useri(nume, prenume, email, parola, card, nr_card));
    }

    //Localuri
    private static Vector<Localuri> localuri = new Vector<Localuri>();

    public static Vector<Localuri> getLocaluri() {
        return localuri;
    }

    public static void adaugaMancare(final String nume, String locatie, String specific, float media) {

        localuri.add(new Localuri(nume, locatie, specific, media));
    }

    //    Meniu
    private static Vector<Meniu> meniu = new Vector<Meniu>();

    public static Vector<Meniu> getMeniu() {
        return meniu;
    }

    public static void adaugaMeniu(String nume_mancare, String descriere, boolean disponibilitate, int pret, boolean reduceri, Localuri localuri) {

        meniu.add(new Meniu(nume_mancare, descriere, disponibilitate, pret, reduceri, localuri));
    }
}
