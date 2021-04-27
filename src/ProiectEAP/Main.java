package ProiectEAP;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        File conturi=new File("src/ProiectEAP/Conturi.txt");
        Scanner citire_conturi;
            try {
                citire_conturi = new Scanner(conturi);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
                citire_conturi=null;
            }
        citire_conturi.useDelimiter("[,\\n]");
        String[] date_user=new String[6];
        int i=0;
        while(citire_conturi.hasNext())
        {
            date_user[i]=citire_conturi.next();
            i++;
        }
        Useri Alex=new Useri(date_user[0],date_user[1],date_user[2],date_user[3],date_user[4],date_user[5]);
        System.out.println(Alex.getEmail());






        Scanner scanner = new Scanner(System.in);
        int decizie;
        do {

//            Afisare posibilitati de alegere

            System.out.println("Doriti sa adaugati un cont nou? -> 1");
            System.out.println("Doriti sa afisati conturile? -> 2");
            System.out.println("Doriti sa adaugati un nou local ? -> 3");
            System.out.println("Doriti sa afisati toate localurile ? -> 4");
            System.out.println("Doriti sa adaugati vreun preparat nou in meniu ? -> 5");
            System.out.println("Doriti sa afisati meniul ? -> 6");
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
            decizie = Integer.parseInt(scanner.next());

//            Citire si declarare a valorii ce are rolul de a reprezenta alegerea facuta.

            int procedura;
            while (decizie > 14 || decizie < 0) {
                System.out.println("Alegerea nu exista. Reintroduceti numarul corespondent actiunii pe care doriti sa o faceti.");
                decizie = Integer.parseInt(scanner.next());

            }

//            Acel "if" de mai sus are rolul de a verifica daca actiunea pe care vrem sa o facem exista.

            if (decizie == 1)

//                Acest if ne introduce intr-o bucla ce are ca rol adaugarea de noi user pana in clipa in care utilizator nu mai doreste acest lucru

                do {
                    procedura = 1;

//                    "procedura" are rol de variabila control aceasta schimbanduse in clipa in care utilizatorul nu mai doreste introducerea de noi date

                    System.out.println("Nume utilizator :");
                    String nume = scanner.next();
                    System.out.println("Prenume utilizator :");
                    String prenume = scanner.next();
                    System.out.println("Email utilizator :");
                    String email = scanner.next();
                    System.out.println("Parola utilizator :");
                    String parola = scanner.next();
                    System.out.println("Doriti sa adaugati si cardul in cont ? ");
                    System.out.println("Pentru da tastati ->DA ");
                    System.out.println("Pentru nu tastati ->NU ");
                    String var;
                    String card = "0";
                    String nr_card = "0";
                    var = scanner.next();

//                    Verificarea acordului utilizatorului de a introduce si cardul sau introducerea automata in camp cu valorea "Fara card"

                    while (var.toUpperCase().equals("DA") == false && var.toUpperCase().equals("NU") == false) {
                        System.out.println("Valoarea introdusa este gresita! Introduceti valoarea corecta.");
                        var = scanner.next();
                    }
                    if (var.toUpperCase().equals("DA") == true) {
                        System.out.println("Tip card :");
                        card = scanner.next();
                        System.out.println("Numar card :");
                        nr_card = scanner.next();
                    } else if (var.toUpperCase().equals("NU") == true) {
                        card = "Fara card";
                        nr_card = "Fara card";

                    }

//                        Crearea obiectului User

                    Servicii.adaugaUseri(nume, prenume, email, parola, card, nr_card);

//                    Verificarea acordului utilizatorului de a introduce inca un utilizator

                    System.out.println("Doriti sa mai creati vreun cont ? ");
                    System.out.println("Pentru da tastati ->DA ");
                    System.out.println("Pentru nu tastati ->NU ");
                    var = scanner.next();
                    while (var.toUpperCase().equals("DA") == false && var.toUpperCase().equals("NU") == false) {
                        System.out.println("Valoarea introdusa este gresita! Introduceti valoarea corecta.");
                        var = scanner.next();

                    }
                    if (var.toUpperCase().equals("NU") == true)
                        procedura = 3;


                } while (procedura == 1);
            else if (decizie == 2) {

//                Afisarea tuturor userilor;

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

//                    Preluarea datelor necesare pentru adaugarea unui nou local

                    procedura = 1;
                    System.out.println("Nume local :");
                    String nume = scanner.next();
                    System.out.println("Locatia localului :");
                    String locatie = scanner.next();
                    System.out.println("Specificul localului :");
                    String specific = scanner.next();
                    System.out.println("ratingul localului :");
                    float rating = Float.parseFloat(scanner.next());
                    Servicii.adaugaLocaluri(nume, locatie, specific, rating);


                    System.out.println("Doriti sa mai adugati vreun local ? ");
                    System.out.println("Pentru da tastati ->DA ");
                    System.out.println("Pentru nu tastati ->NU ");

//                    Iesirea din bucla pentru a nu mai introduce noi utilizatori

                    String var = scanner.next();
                    while (var.toUpperCase().equals("DA") == false && var.toUpperCase().equals("NU") == false) {
                        System.out.println("Valoarea introdusa este gresita! Introduceti valoarea corecta.");
                        var = scanner.next();

                    }
                    if (var.toUpperCase().equals("NU") == true)
                        procedura = -1;
                } while (procedura == 1);
            } else if (decizie == 4) {
                Servicii.getLocaluri().forEach((iteraror) -> {

//                    Afisarea tuturor localurilor

                    System.out.println("Nume local : " + iteraror.getNume());
                    System.out.println("Locatie local : " + iteraror.getLocatie());
                    System.out.println("Specificul localului : " + iteraror.getSpecific());
                    System.out.println("ratingul utilizator : " + iteraror.getMedia());

                });
            } else if (decizie == 5)
                do {

//                  Citirea datelor necesare pentru crearea unui nou meniu

                    procedura = 1;
                    System.out.println("Nume preparat :");
                    String nume = scanner.next();
                    System.out.println("Descriere preparat :");
                    String descriere = scanner.next();
                    System.out.println("Disponibilitate preparat :");
                    System.out.println("Pentru da tastati ->DA ");
                    System.out.println("Pentru nu tastati ->NU ");
                    String var = scanner.next();
                    boolean disponibilitate = false;
                    while (var.toUpperCase().equals("DA") == false && var.toUpperCase().equals("NU") == false) {
                        System.out.println("Valoarea introdusa este gresita! Introduceti valoarea corecta.");
                        var = scanner.next();
                    }
                    if (var.toUpperCase().equals("DA") == true)
                        disponibilitate = true;
                    else if (var.toUpperCase().equals("NU") == true)
                        disponibilitate = false;


                    System.out.println("Pret preparat :");
                    int pret = Integer.parseInt(scanner.next());
                    System.out.println("Reduceri preparat :");
                    System.out.println("Pentru da tastati ->DA ");
                    System.out.println("Pentru nu tastati ->NU ");
                    boolean reduceri = false;
                    var = scanner.next();
                    while (var.toUpperCase().equals("DA") == false && var.toUpperCase().equals("NU") == false) {
                        System.out.println("Valoarea introdusa este gresita! Introduceti valoarea corecta.");
                        var = scanner.next();
                    }
                    if (var.toUpperCase().equals("DA") == true)
                        reduceri = true;
                    else if (var.toUpperCase().equals("NU") == true)
                        reduceri = false;

//                    Crearea unui obiect meniu

                    Servicii.adaugaMeniu(nume, descriere, disponibilitate, pret, reduceri);

//                    Iesirea din bucla pentru a nu mai introduce noi utilizatori
                    System.out.println("Doriti sa mai adaugati vreun preparat in meniu ? ");
                    System.out.println("Pentru da tastati ->DA ");
                    System.out.println("Pentru nu tastati ->NU ");

                    //Iesirea din bucla pentru a nu mai introduce noi preparate

                    var = scanner.next();
                    while (var.toUpperCase().equals("DA") == false && var.toUpperCase().equals("NU") == false) {
                        System.out.println("Valoarea introdusa este gresita! Introduceti valoarea corecta.");
                        var = scanner.next();
                    }
                    if (var.toUpperCase().equals("NU") == true)
                        procedura = 3;
                }
                while (procedura == 1);
            else if (decizie == 6) {
                Servicii.getMeniu().forEach((iteraror) -> {
                    System.out.println("Nume preparat : " + iteraror.getNume_mancare());
                    System.out.println("Descriere preparat : " + iteraror.getDescriere());
                    if (iteraror.isDisponibilitate()) {
                        System.out.println("Preparatul este disponibil !");
                    } else {
                        System.out.println("Preparat indisponibil pentru moment ! ");
                    }
                    System.out.println("Pret preparat : " + iteraror.getPret());
                    if (iteraror.isReduceri()) {
                        System.out.println("Preparatul este redus !");
                    } else {
                        System.out.println("Preparat are pret intreg !");
                    }

                });
            } else if (decizie == 7) {
                do {
                    procedura = 1;

//                Colectare de date pentru crearea unui nou voucher

                    System.out.println("Cod voucher : ");
                    int cod = Integer.parseInt(scanner.next());
                    System.out.println("Descriere voucher :");
                    String descriere = scanner.next();

//                Crearea obiectului

                    Servicii.adaugaVoucher(cod, descriere);

//                Iesirea din bucla in cazul in care nu se mai doreste introducerea de noi voucere

                    System.out.println("Doriti sa mai creati vreun voucher ? ");
                    System.out.println("Pentru da tastati ->DA ");
                    System.out.println("Pentru nu tastati ->NU ");
                    String var = scanner.next();
                    while (var.toUpperCase().equals("DA") == false && var.toUpperCase().equals("NU") == false) {
                        System.out.println("Valoarea introdusa este gresita! Introduceti valoarea corecta.");
                        var = scanner.next();

                    }
                    if (var.toUpperCase().equals("NU") == true)
                        procedura = 3;
                } while (procedura == 1);
            } else if (decizie == 8) {

//                Afisarea tuturor voucerelor

                Servicii.getVoucher().forEach((iteraror) -> {
                    System.out.println("Cod voucher : " + iteraror.getCod());
                    System.out.println("Descriere voucher : " + iteraror.getDescriere());
                });
            } else if (decizie == 9) {
                do {
                    procedura = 1;

//                Colectarea datelorpentru crearea unui nou sofer

                    System.out.println("Nume sofer :");
                    String denumire = scanner.next();
                    System.out.println("Aparat POS :");
                    System.out.println("Pentru da tastati ->DA ");
                    System.out.println("Pentru nu tastati ->NU ");
                    String var = scanner.next();
                    boolean Pos = false;
                    while (var.toUpperCase().equals("DA") == false && var.toUpperCase().equals("NU") == false) {
                        System.out.println("Valoarea introdusa este gresita! Introduceti valoarea corecta.");
                        var = scanner.next();
                    }
                    if (var.toUpperCase().equals("DA") == true)
                        Pos = true;
                    else if (var.toUpperCase().equals("NU") == true)
                        Pos = false;

                    System.out.println("Vehicul :");
                    String vehicul = scanner.next();

//            Creare obiect sofer

                    Servicii.adaugaSoferi(denumire, Pos, vehicul);

//                Parasire bucla adaugare soferi

                    System.out.println("Doriti sa mai creati vreun sofer ? ");
                    System.out.println("Pentru da tastati ->DA ");
                    System.out.println("Pentru nu tastati ->NU ");
                    while (var.toUpperCase().equals("DA") == false && var.toUpperCase().equals("NU") == false) {
                        System.out.println("Valoarea introdusa este gresita! Introduceti valoarea corecta.");
                        var = scanner.next();

                    }
                    if (var.toUpperCase().equals("NU") == true)
                        procedura = -1;
                } while (procedura == 1);
            } else if (decizie == 10) {

//                Afisarea tuturor soferilor

                Servicii.getSoferi().forEach((iteraror) -> {
                    System.out.println("Nume preparat : " + iteraror.getNume());
                    if (iteraror.isPOS()) {
                        System.out.println("Soferul are POS !");
                    } else {
                        System.out.println("Soferul nu are POS !");
                    }
                    System.out.println("Pret preparat : " + iteraror.getVehicul());
                });
            } else if (decizie == 11) {
                do {
                    procedura = 1;

//                Colectare date cu scopul folosirii in crearea comenzii

                    System.out.println("Numarul comenzii ? ");
                    int nr_comanda = Integer.parseInt(scanner.next());

//                Crearea obiectului comanda

                    Servicii.adaugaComenzi(nr_comanda);

//                Iesirea din bucla creata in cazul in care utilizatorul nu mai doreste sa adauge si alte comenzi

                    System.out.println("Doriti sa mai creati vreo comanda ? ");
                    System.out.println("Pentru da tastati ->DA ");
                    System.out.println("Pentru nu tastati ->NU ");
                    String var = scanner.next();
                    while (var.toUpperCase().equals("DA") == false && var.toUpperCase().equals("NU") == false) {
                        System.out.println("Valoarea introdusa este gresita! Introduceti valoarea corecta.");
                        var = scanner.next();

                    }
                    if (var.toUpperCase().equals("NU") == true)
                        procedura = 3;
                } while (procedura == 1);
            } else if (decizie == 12) {

//                Afisarea tuturor comenzilor

                Servicii.getComenzi().forEach((iteraror) -> {
                    System.out.println("Numar comanda : " + iteraror.getNr_comanda());
                });
            } else if (decizie == 13) {
                do {
                    procedura = 1;

//                Colectarea de date necesare pentru crearea unei recenzii

                    System.out.println("Numar rating ? ");
                    int nr_rat = Integer.parseInt(scanner.next());
                    System.out.println("Nota ? ");
                    int nota = Integer.parseInt(scanner.next());
                    System.out.println("Comentariu :");
                    String com = scanner.next();

//                Creare obiect comentariu

                    Servicii.adaugaRecenzie(nr_rat, nota, com);

//             Paarasirea buclei in cazul in care utilizatorul nu mai doreste adaugarea altei recenzii
                    System.out.println("Doriti sa mai creati vreo recenzie ? ");
                    System.out.println("Pentru da tastati ->DA ");
                    System.out.println("Pentru nu tastati ->NU ");
                    String var = scanner.next();
                    while (var.toUpperCase().equals("DA") == false && var.toUpperCase().equals("NU") == false) {
                        System.out.println("Valoarea introdusa este gresita! Introduceti valoarea corecta.");
                        var = scanner.next();

                    }
                    if (var.toUpperCase().equals("NU") == true)
                        procedura = 3;
                } while (procedura == 1);
            } else if (decizie == 14) {

//                Afisarea tuturor recenzii

                Servicii.getRecenzie().forEach((iteraror) -> {
                    System.out.println("Numarul ratingului : " + iteraror.getNr_rating());
                    System.out.println("Nota : " + iteraror.getNota());
                    System.out.println("Comentariu : " + iteraror.getComentariu());

                });
            }

        }
        while (decizie != 0);

    }
}
