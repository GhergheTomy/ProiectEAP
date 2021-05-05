package ProiectEAP;

public class Comenzi {
//    private Useri useri;
    private int nr_comanda;
//    private Meniu meniu;
//    private Soferi soferi;

    public Comenzi(int nr_comanda) {
//        this.useri = useri;
        this.nr_comanda = nr_comanda;
//        this.meniu = meniu;
//        this.soferi = soferi;
    }

//    public Useri getUseri() {
//        return useri;
//    }

    public int getNr_comanda() {
        return nr_comanda;
    }

//    public Meniu getMeniu() {
//        return meniu;
//    }
//
//    public Soferi getSoferi() {
//        return soferi;
//    }

    @Override
    public String toString() {
        return  nr_comanda +",";
    }
}
