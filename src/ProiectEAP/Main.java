package ProiectEAP;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int decizie;
        do {
            System.out.println("Doriti sa adaugati un cont nou? -> 1");
            System.out.println("Doriti sa afisati conturile? -> 2");
            System.out.println("Doriti sa adaugati un nou local ? -> 3");
            System.out.println("Doriti sa afisati toate localurile ? -> 4");
            System.out.println("Doriti sa adaugati un nou meniu ? -> 5");
            System.out.println("Doriti sa afisati toate meniurile ? -> 6");
            System.out.println("Doriti sa adaugati un nou vaucher ? -> 7");
            System.out.println("Doriti sa afisati toate vaucherele ? -> 8");
            System.out.println("Doriti sa adaugati un nou sofer ? -> 9");
            System.out.println("Doriti sa afisati toti soferii ? -> 10");
            System.out.println("Doriti sa adaugati o noua comanda ? -> 11");
            System.out.println("Doriti sa afisati toate comenzile ? -> 12");
            System.out.println("Doriti sa adaugati o noua recenzie ? -> 13");
            System.out.println("Doriti sa afisati toate recenziile ? -> 14");
            System.out.println("Doriti sa inchideti programul ? -> 0");
            System.out.println("Introduceti raspunsul reperezntat de numarul caracteristic :");
            decizie = Integer.parseInt(scanner.nextLine());
            int procedura;
            if (decizie == 1)
                do {
                    procedura = 1;
                    System.out.println("Nume utilizator :");
                    String nume = scanner.nextLine();
                    System.out.println("Prenume utilizator :");
                    String prenume = scanner.nextLine();
                    System.out.println("Email utilizator :");
                    String email = scanner.nextLine();
                    System.out.println("Parola utilizator :");
                    String parola = scanner.nextLine();
                    System.out.println("Doriti sa adaugati si cardul in cont ? ");
                    System.out.println("Pentru da tastati ->1 ");
                    System.out.println("Pentru nu tastati ->2 ");
                    int ok;
                    String card = "0";
                    String nr_card = "0";
                    ok = Integer.parseInt(scanner.nextLine());
                    while (ok != -1) {
                        if (ok == 1) {
                            System.out.println("Tip card :");
                            card = scanner.nextLine();
                            System.out.println("Numar card :");
                            nr_card = scanner.nextLine();
                            ok = -1;
                        } else if (ok == 2) {
                            card = "Fara card";
                            nr_card = "Fara card";
                            ok = -1;
                        } else {
                            System.out.println("Numarul introdus este gresit! Introduceti valoarea corecta.");
                            ok = Integer.parseInt(scanner.nextLine());
                        }
                    }
                    Servicii.adaugaUseri(nume, prenume, email, parola, card, nr_card);
                    System.out.println("Doriti sa mai creati vre-un cont ? ");
                    System.out.println("Pentru da tastati ->1 ");
                    System.out.println("Pentru nu tastati ->2 ");
                    ok = Integer.parseInt(scanner.nextLine());
                    while (ok != -1)
                        if (ok == 2) {
                            procedura = -1;
                            ok = -1;
                        } else if (ok != 1 && ok != 2)
                            System.out.println("Numarul introdus este gresit! Introduceti valoarea corecta.");
                        else ok = -1;
                } while (procedura == 1);
            else if (decizie == 2) {
                Servicii.getUseri().forEach((iteraror) -> {
                    System.out.println("Nume utilizator : " + iteraror.getNume());
                    System.out.println("Prenume utilizator : " + iteraror.getPrenume());
                    System.out.println("Email utilizator : " + iteraror.getEmail());
                    System.out.println("Parola utilizator : " + iteraror.getParola());
                    System.out.println("Card utilizator : " + iteraror.getCard());
                    System.out.println("Numar card utilizator : " + iteraror.getNr_card());
                });
            } else if (decizie == 3) {
                do {
                    procedura = 1;
                    System.out.println("Nume local :");
                    String nume = scanner.nextLine();
                    System.out.println("Locatia localului :");
                    String locatie = scanner.nextLine();
                    System.out.println("Specificul localului :");
                    String specific = scanner.nextLine();
                    System.out.println("Raitingul localului :");
                    float raiting = Float.parseFloat(scanner.nextLine());
                    Servicii.adaugaLocaluri(nume, locatie, specific, raiting);
                    int ok;
                    System.out.println("Doriti sa mai adugati vre-un local ? ");
                    System.out.println("Pentru da tastati ->1 ");
                    System.out.println("Pentru nu tastati ->2 ");
                    ok = Integer.parseInt(scanner.nextLine());
                    while (ok != -1)
                        if (ok == 2) {
                            procedura = -1;
                            ok = -1;
                        } else if (ok != 1 && ok != 2)
                            System.out.println("Numarul introdus este gresit! Introduceti valoarea corecta.");
                        else ok = -1;
                } while (procedura == 1);
            } else if (decizie == 4) {
                Servicii.getLocaluri().forEach((iteraror) -> {
                    System.out.println("Nume local : " + iteraror.getNume());
                    System.out.println("Locatie local : " + iteraror.getLocatie());
                    System.out.println("Specificul localului : " + iteraror.getSpecific());
                    System.out.println("Raitingul utilizator : " + iteraror.getMedia());

                });
            } else if (decizie == 5)
                do {

                    procedura = 1;
                    System.out.println("Nume preparat :");
                    String nume = scanner.nextLine();
                    System.out.println("Descriere preparat :");
                    String descriere = scanner.nextLine();
                    System.out.println("Disponibilitate preparat :");
                    System.out.println("Pentru da tastati ->1 ");
                    System.out.println("Pentru nu tastati ->0 ");
                    int ok = -2;
                    boolean disponibilitate = false;
                    while (ok != -1) {
                        if (ok == 0) {
                            disponibilitate = Boolean.parseBoolean(scanner.nextLine());
                            ok = -1;
                        } else if (ok == 1) {
                            disponibilitate = Boolean.parseBoolean(scanner.nextLine());
                            ok = -1;
                        } else if (ok != 0 && ok != 1) {
                            System.out.println("Numarul introdus este gresit! Introduceti valoarea corecta.");
                            ok = Integer.parseInt(scanner.nextLine());
                        }
                    }
                    System.out.println("Pret preparat :");
                    int pret = Integer.parseInt(scanner.nextLine());
                    System.out.println("Reduceri preparat :");
                    System.out.println("Pentru da tastati ->1 ");
                    System.out.println("Pentru nu tastati ->0 ");
                    boolean reduceri = false;
                    while (ok != -1) {
                        if (ok == 0) {
                            reduceri = Boolean.parseBoolean(scanner.nextLine());
                            ok = -1;
                        } else if (ok == 1) {
                            reduceri = Boolean.parseBoolean(scanner.nextLine());
                            ok = -1;
                        } else if (ok != 0 && ok != 1) {
                            System.out.println("Numarul introdus este gresit! Introduceti valoarea corecta.");
                            ok = Integer.parseInt(scanner.nextLine());
                        }
                        System.out.println("Nume local apartenenta :");
                        String loc = scanner.nextLine();
                        Localuri local = Servicii.getLcoalByName(loc);
                        Servicii.adaugaMeniu(nume, descriere, disponibilitate, pret, reduceri, local);
                    }
                    ok = Integer.parseInt(scanner.nextLine());
                    while (ok != -1)
                        if (ok == 2) {
                            procedura = -1;
                            ok = -1;
                        } else if (ok != 1 && ok != 2)
                            System.out.println("Numarul introdus este gresit! Introduceti valoarea corecta.");
                        else ok = -1;
                }
                while (decizie == 5);
            else if (decizie == 6) {
                Servicii.getLocaluri().forEach((iteraror) -> {
                    System.out.println("Nume local : " + iteraror.getNume());
                    System.out.println("Locatie local : " + iteraror.getLocatie());
                    System.out.println("Specificul localului : " + iteraror.getSpecific());
                    System.out.println("Raitingul utilizator : " + iteraror.getMedia());

                });
            }
        }
        while (decizie != 0);

    }
}
