package ProiectEAP;

public class Voucher {
    private int cod;
    private String descriere;

    public Voucher(int cod, String descriere) {
        this.cod = cod;
        this.descriere = descriere;
    }

    public int getCod() {
        return cod;
    }

    public String getDescriere() {
        return descriere;
    }

    @Override
    public String toString() {
        return  cod +","+ descriere + ",";
    }
}
