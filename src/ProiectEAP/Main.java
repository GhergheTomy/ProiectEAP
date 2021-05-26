package ProiectEAP;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Object> citire(File fisier,int caz){
        try {
            Scanner parametrii= new Scanner(fisier);
            ArrayList<Object> lista=new ArrayList<>();
            parametrii.useDelimiter("[,\\n]+");
            while(parametrii.hasNext())
            {
                if(caz==2)
                    {
                     String[] date_user=new String[6];
                    for(int i=0;i<6;i++)
                        date_user[i]=parametrii.next();
                    lista.add(new Useri(date_user[0],date_user[1],date_user[2],date_user[3],date_user[4],date_user[5]));
                    }
                else if(caz == 4)
                {
                    String[] date_user=new String[4];
                    for(int i=0;i<4;i++)
                        date_user[i]=parametrii.next();
                    lista.add(new Localuri(date_user[0],date_user[1],date_user[2],Float.parseFloat(date_user[3])));
                }
                else if(caz == 6)
                {
                    String[] date_user=new String[5];
                    for(int i=0;i<5;i++)
                        date_user[i]=parametrii.next();
                    lista.add(new Meniu(date_user[0],date_user[1],Boolean.parseBoolean(date_user[2]),Integer.parseInt(date_user[3]),Boolean.parseBoolean(date_user[4])));
                }
                else if(caz == 8)
                {
                    String[] date_user=new String[2];
                    for(int i=0;i<2;i++)
                        date_user[i]=parametrii.next();
                    lista.add(new Voucher(Integer.parseInt(date_user[0]),date_user[1]));
                }
                else if(caz == 10)
                {
                    String[] date_user=new String[3];
                    for(int i=0;i<3;i++)
                        date_user[i]=parametrii.next();
                    lista.add(new Soferi(date_user[0],Boolean.parseBoolean(date_user[1]),date_user[2]));
                }
                else if(caz == 12)
                {
                    String[] date_user=new String[1];
                    for(int i=0;i<1;i++)
                        date_user[i]=parametrii.next();
                    lista.add(new Comenzi(Integer.parseInt(date_user[0])));
                }
                else if(caz == 14)
                {
                    String[] date_user=new String[3];
                    for(int i=0;i<3;i++)
                        date_user[i]=parametrii.next();
                    lista.add(new Recenzie(Integer.parseInt(date_user[0]),Integer.parseInt(date_user[1]),date_user[2]));
                }
            }
            return lista;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
}

    public static void track(int caz) {

        // Creare fisier
        try {
            FileWriter track = new FileWriter("src/ProiectEAP/Track.txt",true);
            //Creare cazuri
            switch(caz){
                case 1 :
                    track.append("Sa adaugat un utilizator nou " ).append(LocalDateTime.now().toString()).append("\n");
                    break;
                case 2 :
                    track.append("Sa afisat lista de utilizatori").append(LocalDateTime.now().toString()).append("\n");
                    break;
                case 3 :
                    track.append("Sa adaugat un local nou").append(LocalDateTime.now().toString()).append("\n");
                    break;
                case 4 :
                    track.append("Sa afisat lista de localuri").append(LocalDateTime.now().toString()).append("\n");
                    break;
                case 5 :
                    track.append("Sa adaugat un meniu nou").append(LocalDateTime.now().toString()).append("\n");
                    break;
                case 6 :
                    track.append("Sa afisat lista de meniuri").append(LocalDateTime.now().toString()).append("\n");
                    break;
                case 7 :
                    track.append("Sa adaugat un voucher nou").append(LocalDateTime.now().toString()).append("\n");
                    break;
                case 8 :
                    track.append("Sa afisat lista de vouchere").append(LocalDateTime.now().toString()).append("\n");
                    break;
                case 9 :
                    track.append("Sa adaugat un sofer nou").append(LocalDateTime.now().toString()).append("\n");
                    break;
                case 10 :
                    track.append("Sa afisat lista de soferi").append(LocalDateTime.now().toString()).append("\n");
                    break;
                case 11 :
                    track.append("Sa adaugat o comanda nou").append(LocalDateTime.now().toString()).append("\n");
                    break;
                case 12 :
                    track.append("Sa afisat lista de comenzi").append(LocalDateTime.now().toString()).append("\n");
                    break;
                case 13 :
                    track.append("Sa adaugat un recenzie noua").append(LocalDateTime.now().toString()).append("\n");
                    break;
                case 14 :
                    track.append("Sa afisat lista de recenzii").append(LocalDateTime.now().toString()).append("\n");
                    break;
                case 0 :
                    track.append("Sa inchis programul").append(LocalDateTime.now().toString()).append("\n");
                    break;
                case 100 :
                    track.append("Sa deschis programul").append(LocalDateTime.now().toString()).append("\n");
                    break;
                default:track.append("Optiunea aleasa nu a fost corecta");
            }
            track.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws SQLException {

        //Creare scaner

        File conturi=new File("src/ProiectEAP/Conturi.txt");
        Scanner citire_conturi;
        File localuri=new File("src/ProiectEAP/Localuri.txt");
        Scanner citire_localuri;
        File meniuri=new File("src/ProiectEAP/Meniuri.txt");
        Scanner citire_meniuri;
        File vouchere=new File("src/ProiectEAP/Vouchere.txt");
        Scanner citire_vouchere;
        File soferi=new File("src/ProiectEAP/Soferi.txt");
        Scanner citire_soferi;
        File comenzi=new File("src/ProiectEAP/Comenzi.txt");
        Scanner citire_comenzi;
        File recenzii=new File("src/ProiectEAP/Recenzii.txt");
        Scanner citire_recenzii;

        // try and catch pentru evitarea posibilitatii neexistentei fisierului txt

        try {
            citire_conturi = new Scanner(conturi);
        } catch (FileNotFoundException e) {
                e.printStackTrace();
                citire_conturi=null;
        }
        try {
            citire_localuri = new Scanner(localuri);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            citire_localuri = null;
        }
        try {
            citire_meniuri = new Scanner(meniuri);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            citire_meniuri = null;
        }
        try {
            citire_vouchere = new Scanner(vouchere);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            citire_vouchere = null;
        }
        try {
            citire_soferi = new Scanner(soferi);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            citire_soferi = null;
        }
        try {
            citire_comenzi = new Scanner(comenzi);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            citire_comenzi = null;
        }
        try {
            citire_recenzii = new Scanner(recenzii);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            citire_recenzii = null;
        }

        citire_conturi.useDelimiter("[,\\n]+");
        citire_localuri.useDelimiter("[,\\n]+");
        citire_meniuri.useDelimiter("[,\\n]+");
        citire_vouchere.useDelimiter("[,\\n]+");
        citire_soferi.useDelimiter("[,\\n]+");
        citire_comenzi.useDelimiter("[,\\n]+");
        citire_recenzii.useDelimiter("[,\\n]+");

        Scanner scanner = new Scanner(System.in);
        int decizie=100;

        //Apelarea functiei de track
        track(decizie);

        //Initializarea bazei de date
        BazeDeDate.initializare();

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

            if (decizie == 1){

                //Apelarea funtiei track
                track(decizie);

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

                    while (!var.toUpperCase().equals("DA") && !var.toUpperCase().equals("NU")) {
                        System.out.println("Valoarea introdusa este gresita! Introduceti valoarea corecta.");
                        var = scanner.next();
                    }
                    if (var.toUpperCase().equals("DA")) {
                        System.out.println("Tip card :");
                        card = scanner.next();
                        System.out.println("Numar card :");
                        nr_card = scanner.next();
                    } else if (var.toUpperCase().equals("NU")) {
                        card = "Fara card";
                        nr_card = "Fara card";

                    }

                    //Adaugarea obiectului user in baza de date
                    BazeDeDate.inserare_user(nume,prenume,email,parola,card,nr_card);

////                        Crearea obiectului User
//
//                    Servicii.adaugaUseri(nume, prenume, email, parola, card, nr_card);
//
//                    try {
//                        FileWriter salvare_conturi=new FileWriter(conturi,true);
//                        salvare_conturi.append("\n");
//                            Servicii.getUseri().forEach(e-> {
//                                try {
//                                    salvare_conturi.append(e.toString());
//                                } catch (IOException ioException) {
//                                    ioException.printStackTrace();
//                                }
//                            });
//                        salvare_conturi.close();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }

//                    Verificarea acordului utilizatorului de a introduce inca un utilizator

                    System.out.println("Doriti sa mai creati vreun cont ? ");
                    System.out.println("Pentru da tastati ->DA ");
                    System.out.println("Pentru nu tastati ->NU ");
                    var = scanner.next();
                    while (!var.toUpperCase().equals("DA") && !var.toUpperCase().equals("NU")) {
                        System.out.println("Valoarea introdusa este gresita! Introduceti valoarea corecta.");
                        var = scanner.next();

                    }
                    if (var.toUpperCase().equals("NU"))
                        procedura = 3;


                } while (procedura == 1);}
            else if (decizie == 2) {

                //Apelarea funtiei track
                track(decizie);

//                Afisarea tuturor userilor;

                //Afisarea utilizatorilor din baza de date
                BazeDeDate.afisare_useri();

//                ArrayList<Useri> useri=new ArrayList<>();
//                for(Object i:citire(conturi,decizie))
//                    useri.add((Useri) i);
//                try {
//                    FileWriter salvare_conturi=new FileWriter(conturi,true);
//                    salvare_conturi.append("\n");
//                    for(Useri j:useri)
//                    {
//                        System.out.println(j.toString());
//                    }
//                    System.out.println("");
//                    salvare_conturi.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
            } else if (decizie == 3) {

                //Apelarea funtiei track
                track(decizie);

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

                    //Adaugarea localului in baza de date
                    BazeDeDate.inserare_local(nume,locatie,specific,rating);

//                    try {
//                        FileWriter salvare_localuri=new FileWriter(localuri,true);
//                        salvare_localuri.append("\n");
//                        Servicii.getLocaluri().forEach(e-> {
//                            try {
//                                salvare_localuri.append(e.toString());
//                            } catch (IOException ioException) {
//                                ioException.printStackTrace();
//                            }
//                        });
//                        salvare_localuri.close();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }

                    System.out.println("Doriti sa mai adugati vreun local ? ");
                    System.out.println("Pentru da tastati ->DA ");
                    System.out.println("Pentru nu tastati ->NU ");

//                    Iesirea din bucla pentru a nu mai introduce noi utilizatori

                    String var = scanner.next();
                    while (!var.toUpperCase().equals("DA") && !var.toUpperCase().equals("NU")) {
                        System.out.println("Valoarea introdusa este gresita! Introduceti valoarea corecta.");
                        var = scanner.next();



                    }
                    if (var.toUpperCase().equals("NU"))
                        procedura = -1;
                } while (procedura == 1);
            } else if (decizie == 4) {

                //Apelarea funtiei track
                track(decizie);

                //Afisarea localurilor din baza de date
                BazeDeDate.afisare_localuri();

//                Afisarea tuturor localurilor;

//                ArrayList<Localuri> local=new ArrayList<>();
//                for(Object i:citire(localuri,decizie))
//                    local.add((Localuri) i);
//                try {
//                    FileWriter salvare_localuri=new FileWriter(localuri,true);
//                    salvare_localuri.append("\n");
//                    for(Localuri j:local)
//                    {
//                        System.out.println(j.toString());
//                    }
//                    System.out.println("");
//                    salvare_localuri.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
            } else if (decizie == 5){

                //Apelarea funtiei track
                track(decizie);

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
                    while (!var.toUpperCase().equals("DA") && !var.toUpperCase().equals("NU")) {
                        System.out.println("Valoarea introdusa este gresita! Introduceti valoarea corecta.");
                        var = scanner.next();
                    }
                    if (var.toUpperCase().equals("DA"))
                        disponibilitate = true;

                    System.out.println("Pret preparat :");
                    int pret = Integer.parseInt(scanner.next());
                    System.out.println("Reduceri preparat :");
                    System.out.println("Pentru da tastati ->DA ");
                    System.out.println("Pentru nu tastati ->NU ");
                    boolean reduceri = false;
                    var = scanner.next();
                    while (!var.toUpperCase().equals("DA") && !var.toUpperCase().equals("NU")) {
                        System.out.println("Valoarea introdusa este gresita! Introduceti valoarea corecta.");
                        var = scanner.next();
                    }
                    if (var.toUpperCase().equals("DA"))
                        reduceri = true;

//                    Crearea unui obiect meniu

                    Servicii.adaugaMeniu(nume, descriere, disponibilitate, pret, reduceri);

                    //Inserare meniu in baza de date
                    BazeDeDate.inserare_meniu(nume,descriere,disponibilitate,pret,reduceri);

//                    try {
//                        FileWriter salvare_meniuri=new FileWriter(meniuri,true);
//                        salvare_meniuri.append("\n");
//                        Servicii.getMeniu().forEach(e-> {
//                            try {
//                                salvare_meniuri.append(e.toString());
//                            } catch (IOException ioException) {
//                                ioException.printStackTrace();
//                            }
//                        });
//                        salvare_meniuri.close();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }

//                    Iesirea din bucla pentru a nu mai introduce noi utilizatori
                    System.out.println("Doriti sa mai adaugati vreun preparat in meniu ? ");
                    System.out.println("Pentru da tastati ->DA ");
                    System.out.println("Pentru nu tastati ->NU ");

                    //Iesirea din bucla pentru a nu mai introduce noi preparate

                    var = scanner.next();
                    while (!var.toUpperCase().equals("DA") && !var.toUpperCase().equals("NU")) {
                        System.out.println("Valoarea introdusa este gresita! Introduceti valoarea corecta.");
                        var = scanner.next();
                    }
                    if (var.toUpperCase().equals("NU"))
                        procedura = 3;
                }
                while (procedura == 1);}
            else if (decizie == 6){

                //Apelarea funtiei track
                track(decizie);

                //Apelare functie afirae meniuri baza de date
                BazeDeDate.afisare_meniu();

////                Afisarea tuturor meniurilor;
//
//                ArrayList<Meniu> meniu=new ArrayList<>();
//                for(Object i:citire(meniuri,decizie))
//                    meniu.add((Meniu) i);
//                try {
//                    FileWriter salvare_meniuri=new FileWriter(meniuri,true);
//                    salvare_meniuri.append("\n");
//                    System.out.println("Nume Preparat ,Descriere,Disponibilitate,Pret,Reduceri");
//                    for(Meniu j:meniu)
//                    {
//                        System.out.println(j.toString());
//                    }
//                    System.out.println("");
//                    salvare_meniuri.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
            } else if (decizie == 7) {

                //Apelarea funtiei track
                track(decizie);

                do {
                    procedura = 1;

//                Colectare de date pentru crearea unui nou voucher

                    System.out.println("Cod voucher : ");
                    int cod = Integer.parseInt(scanner.next());
                    System.out.println("Descriere voucher :");
                    String descriere = scanner.next();

//                Crearea obiectului

                    Servicii.adaugaVoucher(cod, descriere);

                    //Inserare voucher in baza de date
                    BazeDeDate.inserare_voucher(cod,descriere);

//                    try {
//                        FileWriter salvare_vouchere=new FileWriter(vouchere,true);
//                        salvare_vouchere.append("\n");
//                        Servicii.getVoucher().forEach(e-> {
//                            try {
//                                salvare_vouchere.append(e.toString());
//                            } catch (IOException ioException) {
//                                ioException.printStackTrace();
//                            }
//                        });
//                        salvare_vouchere.close();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }

//                Iesirea din bucla in cazul in care nu se mai doreste introducerea de noi voucere

                    System.out.println("Doriti sa mai creati vreun voucher ? ");
                    System.out.println("Pentru da tastati ->DA ");
                    System.out.println("Pentru nu tastati ->NU ");
                    String var = scanner.next();
                    while (!var.toUpperCase().equals("DA") && !var.toUpperCase().equals("NU")) {
                        System.out.println("Valoarea introdusa este gresita! Introduceti valoarea corecta.");
                        var = scanner.next();

                    }
                    if (var.toUpperCase().equals("NU"))
                        procedura = 3;
                } while (procedura == 1);
            } else if (decizie == 8){

                //Apelarea funtiei track
                track(decizie);

                //Apelare functie cu rolul afisarii voucherelor
                BazeDeDate.afisare_vouchere();

////                Afisarea tuturor voucherelor;
//
//                ArrayList<Voucher> voucher=new ArrayList<>();
//                for(Object i:citire(vouchere,decizie))
//                    voucher.add((Voucher) i);
//                try {
//                    FileWriter salvare_vouchere=new FileWriter(vouchere,true);
//                    salvare_vouchere.append("\n");
//                    System.out.println("Cod , Descriere");
//                    for(Voucher j:voucher)
//                    {
//                        System.out.println(j.toString());
//                    }
//                    System.out.println("");
//                    salvare_vouchere.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
            }else if (decizie == 9) {

                //Apelarea funtiei track
                track(decizie);

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
                    while (!var.toUpperCase().equals("DA") && !var.toUpperCase().equals("NU")) {
                        System.out.println("Valoarea introdusa este gresita! Introduceti valoarea corecta.");
                        var = scanner.next();
                    }
                    if (var.toUpperCase().equals("DA"))
                        Pos = true;

                    System.out.println("Vehicul :");
                    String vehicul = scanner.next();

//            Creare obiect sofer

                    Servicii.adaugaSoferi(denumire, Pos, vehicul);

                    //Inserarea unui sofer in baza de date
                    BazeDeDate.inserare_soferi(denumire,Pos,vehicul);

//                    try {
//                        FileWriter salvare_soferi=new FileWriter(soferi,true);
//                        salvare_soferi.append("\n");
//                        Servicii.getSoferi().forEach(e-> {
//                            try {
//                                salvare_soferi.append(e.toString());
//                            } catch (IOException ioException) {
//                                ioException.printStackTrace();
//                            }
//                        });
//                        salvare_soferi.close();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }

//                Parasire bucla adaugare soferi

                    System.out.println("Doriti sa mai creati vreun sofer ? ");
                    System.out.println("Pentru da tastati ->DA ");
                    System.out.println("Pentru nu tastati ->NU ");
                    var = scanner.next();
                    while (!var.toUpperCase().equals("DA") && !var.toUpperCase().equals("NU")) {
                        System.out.println("Valoarea introdusa este gresita! Introduceti valoarea corecta.");
                        var = scanner.next();

                    }
                    if (var.toUpperCase().equals("NU"))
                        procedura = -1;
                } while (procedura == 1);
            } else if (decizie == 10) {

                //Apelarea funtiei track
                track(decizie);

                //Apelarea functiei cu rolul afisarii de soferi
                BazeDeDate.afisare_soferi();

////                Afisarea tuturor soferilor;
//
//                ArrayList<Soferi> sofer=new ArrayList<>();
//                for(Object i:citire(soferi,decizie))
//                    sofer.add((Soferi) i);
//                try {
//                    FileWriter salvare_soferi=new FileWriter(soferi,true);
//                    salvare_soferi.append("\n");
//                    System.out.println("Nume, Pos, Vehicul");
//                    for(Soferi j:sofer)
//                    {
//                        System.out.println(j.toString());
//                    }
//                    System.out.println("");
//                    salvare_soferi.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
            } else if (decizie == 11) {

                //Apelarea funtiei track
                track(decizie);

                do {
                    procedura = 1;

//                Colectare date cu scopul folosirii in crearea comenzii

                    System.out.println("Numarul comenzii ? ");
                    int nr_comanda = Integer.parseInt(scanner.next());

//                Crearea obiectului comanda

                    Servicii.adaugaComenzi(nr_comanda);

                    //Inserarea unei comenzi in baza de date
                    BazeDeDate.inserare_comanda(nr_comanda);

//                    try {
//                        FileWriter salvare_comenzi=new FileWriter(comenzi,true);
//                        salvare_comenzi.append("\n");
//                        Servicii.getComenzi().forEach(e-> {
//                            try {
//                                salvare_comenzi.append(e.toString());
//                            } catch (IOException ioException) {
//                                ioException.printStackTrace();
//                            }
//                        });
//                        salvare_comenzi.close();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }

//                Iesirea din bucla creata in cazul in care utilizatorul nu mai doreste sa adauge si alte comenzi

                    System.out.println("Doriti sa mai creati vreo comanda ? ");
                    System.out.println("Pentru da tastati ->DA ");
                    System.out.println("Pentru nu tastati ->NU ");
                    String var = scanner.next();
                    while (!var.toUpperCase().equals("DA") && !var.toUpperCase().equals("NU")) {
                        System.out.println("Valoarea introdusa este gresita! Introduceti valoarea corecta.");
                        var = scanner.next();

                    }
                    if (var.toUpperCase().equals("NU"))
                        procedura = 3;
                } while (procedura == 1);
            } else if (decizie == 12) {

                //Apelarea funtiei track
                track(decizie);

                //Apelare functie cu rolul de a afisare comenzi
                BazeDeDate.afisare_comenzi();

////                Afisarea tuturor comenzilor;
//
//                ArrayList<Comenzi> comanda=new ArrayList<>();
//                for(Object i:citire(comenzi,decizie))
//                    comanda.add((Comenzi) i);
//                try {
//                    FileWriter salvare_comenzi=new FileWriter(comenzi,true);
//                    salvare_comenzi.append("\n");
//                    System.out.println("Numar comanda");
//                    for(Comenzi j:comanda)
//                    {
//                        System.out.println(j.toString());
//                    }
//                    System.out.println("");
//                    salvare_comenzi.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
            } else if (decizie == 13) {

                //Apelarea funtiei track
                track(decizie);

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

                    //Inserarea unei noi recenzii in baza de date
                    BazeDeDate.inserare_recenzie(nr_rat,nota,com);

//                    try {
//                        FileWriter salvare_recenzii=new FileWriter(recenzii,true);
//                        salvare_recenzii.append("\n");
//                        Servicii.getRecenzie().forEach(e-> {
//                            try {
//                                salvare_recenzii.append(e.toString());
//                            } catch (IOException ioException) {
//                                ioException.printStackTrace();
//                            }
//                        });
//                        salvare_recenzii.close();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }

//             Paarasirea buclei in cazul in care utilizatorul nu mai doreste adaugarea altei recenzii
                    System.out.println("Doriti sa mai creati vreo recenzie ? ");
                    System.out.println("Pentru da tastati ->DA ");
                    System.out.println("Pentru nu tastati ->NU ");
                    String var = scanner.next();
                    while (!var.toUpperCase().equals("DA") && !var.toUpperCase().equals("NU")) {
                        System.out.println("Valoarea introdusa este gresita! Introduceti valoarea corecta.");
                        var = scanner.next();

                    }
                    if (var.toUpperCase().equals("NU"))
                        procedura = 3;
                } while (procedura == 1);
            } else if (decizie == 14) {

                //Apelarea funtiei track
                track(decizie);

                //Apelare functie cu rolul afisarii recenzilor
                BazeDeDate.afisare_recenzi();

////                Afisarea tuturor comenzilor;
//
//                ArrayList<Recenzie> recenzie=new ArrayList<>();
//                for(Object i:citire(recenzii,decizie))
//                    recenzie.add((Recenzie) i);
//                try {
//                    FileWriter salvare_recenzii=new FileWriter(recenzii,true);
//                    salvare_recenzii.append("\n");
//                    System.out.println("Numar raiting, Nota, Comentariu");
//                    for(Recenzie j:recenzie)
//                    {
//                        System.out.println(j.toString());
//                    }
//                    System.out.println("");
//                    salvare_recenzii.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
            }
//
        }
        while (decizie != 0);

        //Apelarea funtiei track
        track(decizie);

    }
}
