package ProiectEAP;

public class Soferi {
    private String nume;
    private boolean POS;
    private String vehicul;
    private Localuri localuri;

    public Soferi(String nume, boolean POS, String vehicul, Localuri localuri) {
        this.nume = nume;
        this.POS = POS;
        this.vehicul = vehicul;
        this.localuri = localuri;
    }

    public String getNume() {
        return nume;
    }

    public boolean isPOS() {
        return POS;
    }

    public String getVehicul() {
        return vehicul;
    }

    public Localuri getLocaluri() {
        return localuri;
    }

    public void setPOS(boolean POS) {
        this.POS = POS;
    }

    public void setVehicul(String vehicul) {
        this.vehicul = vehicul;
    }

    public void setLocaluri(Localuri localuri) {
        this.localuri = localuri;
    }
}
