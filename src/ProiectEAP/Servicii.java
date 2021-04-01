package ProiectEAP;

import java.util.Vector;

public class Servicii {
    //    Comenzi
    private static Vector<Comenzi> comanda = new Vector<Comenzi>();

    public static Vector<Comenzi> getComenzi() {
        return comanda;
    }

    public static void adaugaComenzi( int nr_comanda) {

        comanda.add(new Comenzi(nr_comanda));
    }

    //    Soferi
    private static Vector<Soferi> sofer = new Vector<Soferi>();

    public static Vector<Soferi> getSoferi() {
        return sofer;
    }

    public static void adaugaSoferi(String nume, boolean POS, String vehicul) {

        sofer.add(new Soferi(nume, POS, vehicul));
    }

    //    Recenzie
    private static Vector<Recenzie> recenzie = new Vector<Recenzie>();

    public static Vector<Recenzie> getRecenzie() {
        return recenzie;
    }

    public static void adaugaRecenzie(final int nr_rating, final int nota, final String comentariu) {

        recenzie.add(new Recenzie(nr_rating, nota, comentariu));
    }

    //Voucher
    private static Vector<Voucher> voucher = new Vector<Voucher>();

    public static Vector<Voucher> getVoucher() {
        return voucher;
    }

    public static void adaugaVoucher(int cod, String descriere) {

        voucher.add(new Voucher(cod, descriere));
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

    public static void adaugaLocaluri(final String nume, String locatie, String specific, float media) {

        localuri.add(new Localuri(nume, locatie, specific, media));
    }

    //    Meniu
    private static Vector<Meniu> meniu = new Vector<Meniu>();

    public static Vector<Meniu> getMeniu() {
        return meniu;
    }

    public static void adaugaMeniu(String nume_mancare, String descriere, boolean disponibilitate, int pret, boolean reduceri) {

        meniu.add(new Meniu(nume_mancare, descriere, disponibilitate, pret, reduceri));
    }

    public static Localuri getLcoalByName(String nume) {
        for(Localuri l:localuri)
            if(l.getNume().equals(nume)) return l;
            return null;
    }
}
