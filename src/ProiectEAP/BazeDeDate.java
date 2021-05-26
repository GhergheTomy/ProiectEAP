package ProiectEAP;

import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;

import java.sql.*;

import java.util.Locale;

public class BazeDeDate {

    private static Connection connection;
    private static Statement statement;

    public BazeDeDate() {
        connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","123456");
            statement = connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //Stergerea vechii bazei de date

    public static void delete_tables() throws SQLException {
        statement.executeUpdate("use proiecteap");
        statement.executeUpdate("DROP TABLE localuri");
        statement.executeUpdate("DROP TABLE meniuri");
        statement.executeUpdate("DROP TABLE soferi");
        statement.executeUpdate("DROP TABLE recenzii");
        statement.executeUpdate("DROP TABLE useri");
        statement.executeUpdate("DROP TABLE vouchere");
        statement.executeUpdate("DROP TABLE comenzi");
    }
    //Creare tabele

    public static void create_tables() throws SQLException {
        statement.executeUpdate("use proiecteap");
        statement.executeUpdate("CREATE TABLE `proiecteap`.`localuri` (\n" +
                "  `Nume` varchar(20) NOT NULL,\n" +
                "  `Locatie` varchar(45) NOT NULL,\n" +
                "  `Specific` varchar(20) NOT NULL,\n" +
                "  `Media` float unsigned zerofill DEFAULT 0,\n" +
                "  PRIMARY KEY (`Nume`,`Locatie`)\n" +
                ")");
        statement.executeUpdate("CREATE TABLE `proiecteap`.`meniuri` (\n" +
                "  `denumire_mancare` VARCHAR(20) NOT NULL,\n" +
                "  `descriere` VARCHAR(80) NOT NULL,\n" +
                "  `disponibilitate` TINYINT(1) NOT NULL,\n" +
                "  `pret` INT NOT NULL,\n" +
                "  `reduceri` TINYINT(1) NOT NULL,\n" +
                "  PRIMARY KEY (`denumire_mancare`));");
        statement.executeUpdate("CREATE TABLE `proiecteap`.`recenzii` (\n" +
                "  `Numar_rating` INT NOT NULL,\n" +
                "  `Nota` INT NOT NULL,\n" +
                "  `Comentariu` VARCHAR(80) NULL DEFAULT 'Fara comentariu',\n" +
                "  PRIMARY KEY (`Numar_rating`));");
        statement.executeUpdate("CREATE TABLE `proiecteap`.`soferi` (\n" +
                "  `Nume` VARCHAR(20) NOT NULL,\n" +
                "  `POS` TINYINT(1) ZEROFILL NOT NULL DEFAULT 0,\n" +
                "  `vehicul` VARCHAR(30) NOT NULL DEFAULT 'Bicicleta',\n" +
                "  PRIMARY KEY (`Nume`));");
        statement.executeUpdate("CREATE TABLE `proiecteap`.`useri` (\n" +
                "  `nume` VARCHAR(15) NOT NULL,\n" +
                "  `prenume` VARCHAR(15) NOT NULL,\n" +
                "  `email` VARCHAR(45) NOT NULL,\n" +
                "  `parola` VARCHAR(45) NOT NULL,\n" +
                "  `card` VARCHAR(45) NULL DEFAULT 'Fara Card',\n" +
                "  `numar_card` VARCHAR(45) NULL DEFAULT 'Fara Card',\n" +
                "  PRIMARY KEY (`nume`));\n");
        statement.executeUpdate("CREATE TABLE `proiecteap`.`vouchere` (\n" +
                "  `cod` INT NOT NULL,\n" +
                "  `Descriere` VARCHAR(45) NOT NULL,\n" +
                "  PRIMARY KEY (`cod`),\n" +
                "  UNIQUE INDEX `cod_UNIQUE` (`cod` ASC) VISIBLE);\n");
        statement.executeUpdate("CREATE TABLE `proiecteap`.`comenzi` (\n" +
                "  `nr_comanda` INT UNSIGNED NOT NULL,\n" +
                "  PRIMARY KEY (`Nr_comanda`));\n");
    }

    //Initializarea bazei de date

    public static void test() throws SQLException {
        statement.executeUpdate("use proiecteap");
    statement.executeUpdate("INSERT INTO `proiecteap`.`localuri` (`Nume`, `Locatie`, `Specific`, `Media`) VALUES ('Jerry Pizza', 'Arges Pitesti', 'Italian', '4.5');");
    statement.executeUpdate("INSERT INTO `proiecteap`.`localuri` (`Nume`, `Locatie`, `Specific`) VALUES ('ItalianPizza', 'ArgesPitesti', 'Italienesc');");
    statement.executeUpdate("INSERT INTO `proiecteap`.`meniuri` (`denumire_mancare`, `descriere`, `disponibilitate`, `pret`, `reduceri`) VALUES ('Paste', 'Putini carbohidrati', '1', '24', '0');");
    statement.executeUpdate("INSERT INTO `proiecteap`.`meniuri` (`denumire_mancare`, `descriere`, `disponibilitate`, `pret`, `reduceri`) VALUES ('Pizza', 'Ingrediente mozzarela,masline salami, sos rosii. 400g', '1', '30', '1');");
    statement.executeUpdate("INSERT INTO `proiecteap`.`meniuri` (`denumire_mancare`, `descriere`, `disponibilitate`, `pret`, `reduceri`) VALUES ('Supa spanac crema', 'Ingrediente apa spanac morcov. 220g', '0', '12', '0');");
    statement.executeUpdate("INSERT INTO `proiecteap`.`recenzii` (`Numar_rating`, `Nota`, `Comentariu`) VALUES ('1', '3', 'A fost ok');");
    statement.executeUpdate("INSERT INTO `proiecteap`.`recenzii` (`Numar_rating`, `Nota`, `Comentariu`) VALUES ('2', '5', 'Excelent am simtit ca mananc mancarea bunicii din copilarie');");
    statement.executeUpdate("INSERT INTO `proiecteap`.`recenzii` (`Numar_rating`, `Nota`, `Comentariu`) VALUES ('3', '1', 'Mancarea a fost rece si fara gust');");
    statement.executeUpdate("INSERT INTO `proiecteap`.`soferi` (`Nume`, `POS`, `vehicul`) VALUES ('Ionel Adrian', '0', 'DACIA Logan');");
    statement.executeUpdate("INSERT INTO `proiecteap`.`soferi` (`Nume`, `POS`, `vehicul`) VALUES ('Bob Dragoiu', '1', 'Kawasaki H2R');");
    statement.executeUpdate("INSERT INTO `proiecteap`.`soferi` (`Nume`, `POS`) VALUES ('Marian Mihai', '1');");
    statement.executeUpdate("INSERT INTO `proiecteap`.`useri` (`nume`, `prenume`, `email`, `parola`) VALUES ('Alex', 'Andrei', 'alex.andrei@yahoo.com', '123456');");
    statement.executeUpdate("INSERT INTO `proiecteap`.`useri` (`nume`, `prenume`, `email`, `parola`, `card`, `numar_card`) VALUES ('Bogdan', 'Gigi', 'bogig@yahoo.com', '32156241', 'MasterCard', '2365485975846547');");
    statement.executeUpdate("INSERT INTO `proiecteap`.`useri` (`nume`, `prenume`, `email`, `parola`, `card`, `numar_card`) VALUES ('Cristian', 'Popi', 'critianpop@yahoo.com', '216542', 'Visa', '4521632596588547');");
    statement.executeUpdate("INSERT INTO `proiecteap`.`useri` (`nume`, `prenume`, `email`, `parola`, `card`, `numar_card`) VALUES ('Ion', 'Ionut', 'ionion@yahoo.com', '5156412', 'MasterCard', '87456985632030214');");
    statement.executeUpdate("INSERT INTO `proiecteap`.`useri` (`nume`, `prenume`, `email`, `parola`, `card`, `numar_card`) VALUES ('Ionel', 'Gheorghe', 'iongheo@yahoo.com', '516541', 'MasterCard', '1258325896327412');");
    statement.executeUpdate("INSERT INTO `proiecteap`.`useri` (`nume`, `prenume`, `email`, `parola`) VALUES ('Adrian', 'Danut', 'adi.dan@yahoo.com', '321654');");
    statement.executeUpdate("INSERT INTO `proiecteap`.`vouchere` (`cod`, `Descriere`) VALUES ('125368', '10% Reducere pentru orice pizza comandata');");
    statement.executeUpdate("INSERT INTO `proiecteap`.`vouchere` (`cod`, `Descriere`) VALUES ('395468', '15% Reducere pentru supele crema');");
    statement.executeUpdate("INSERT INTO `proiecteap`.`vouchere` (`cod`, `Descriere`) VALUES ('134555', '3 % Reducere pt orice bautura comandata');");
    statement.executeUpdate("INSERT INTO `proiecteap`.`comenzi` (`Nr_comanda`) VALUES ('15');");
    statement.executeUpdate("INSERT INTO `proiecteap`.`comenzi` (`Nr_comanda`) VALUES ('13');");
    }

    //Functie inserare Utilizator
    public static void inserare_user(String nume, String prenume,String email, String parola,String card,String nr_card ) throws SQLException {
        statement.executeUpdate("use proiecteap");
        if(card.toUpperCase().equals("FARA CARD"))
        statement.executeUpdate("INSERT INTO `proiecteap`.`useri` (`nume`, `prenume`, `email`, `parola`) VALUES ('"+nume+"', '"+prenume+"', '"+email+"', '"+parola+"');");
    else statement.executeUpdate("INSERT INTO `proiecteap`.`useri` (`nume`, `prenume`, `email`, `parola`, `card`, `numar_card`) VALUES ('"+nume+"', '"+prenume+"', '"+email+"', '"+parola+"', '"+card+"', '"+nr_card+"');");
    }

    //Functie afisare useri din baza de date
    public static void afisare_useri() throws SQLException {
        statement.executeUpdate("use proiecteap");
        ResultSet Rs = statement.executeQuery("SELECT * from useri");
        while (Rs.next()) {
            System.out.println(" User: " + Rs.getString("nume") + " " + " Prenume: " + Rs.getString("prenume") + "  Email: " + Rs.getString("email") + " Parola: " + Rs.getString("parola")+ " Card: "+ Rs.getString("card") + " Numar Card: " + Rs.getString("numar_card"));
        }
    }

    //Functie inserare Local
    public static void inserare_local(String nume,String locatie,String specific,Float nota) throws SQLException {
        statement.executeUpdate("use proiecteap");
        statement.executeUpdate("INSERT INTO `proiecteap`.`localuri` (`Nume`, `Locatie`, `Specific`, `Media`) VALUES ('"+nume+"', '"+locatie+"', '"+specific+"', '"+nota+"');");
    }

    //Functie afisare localuri din baza de date
    public static void afisare_localuri() throws SQLException {
        statement.executeUpdate("use proiecteap");
        ResultSet Rs = statement.executeQuery("SELECT * from localuri");
        while (Rs.next()) {
            System.out.println(" Local: " + Rs.getString("Nume") + " " + " Locatie: " + Rs.getString("Locatie") + "  Specific: " + Rs.getString("Specific") + " Media: " + Rs.getFloat("Media"));
        }
    }

    //Functie inserare Meniu
    public static  void inserare_meniu(String den_mancare,String descriere,Boolean disponibilitate,int pret,Boolean reduceri) throws SQLException {
        statement.executeUpdate("use proiecteap");
        int dis,red;
        if(disponibilitate == true) dis = 1;
        else dis = 0;
        if(reduceri == true) red = 1;
        else red = 0;
        statement.executeUpdate("INSERT INTO `proiecteap`.`meniuri` (`denumire_mancare`, `descriere`, `disponibilitate`, `pret`, `reduceri`) VALUES ('"+den_mancare+"', '"+descriere+"', '"+dis+"', '"+pret+"', '"+red+"');");
    }

    //Functie afisare meniurilor din baza de date
    public static void afisare_meniu() throws SQLException {
        statement.executeUpdate("use proiecteap");
        ResultSet Rs = statement.executeQuery("SELECT * from meniuri");
        while (Rs.next()) {
            System.out.println(" Meniu: " + Rs.getString("denumire_mancare") + " " + " Descriere: " + Rs.getString("descriere") + "  Disponibilitate " + Rs.getBoolean("disponibilitate") + " Pret: " + Rs.getInt("pret")+ " Reduceri: "+ Rs.getBoolean("reduceri"));
        }
    }

    //Functie inserare voucher
    public static void inserare_voucher(int cod,String descriere) throws SQLException {
        statement.executeUpdate("use proiecteap");
        statement.executeUpdate("INSERT INTO `proiecteap`.`vouchere` (`cod`, `Descriere`) VALUES ('"+cod+"', '"+descriere+"');");
    }

    //Functie afisare vouchere din baza de date
    public static void afisare_vouchere() throws SQLException {
        statement.executeUpdate("use proiecteap");
        ResultSet Rs = statement.executeQuery("SELECT * from vouchere");
        while (Rs.next()) {
            System.out.println(" Cod voucher: " + Rs.getInt("cod") + " " + " Descriere: " + Rs.getString("Descriere"));
        }
    }


    //Functie inserare soferi
    public static void inserare_soferi(String nume,Boolean pos,String vehicul) throws SQLException {
        statement.executeUpdate("use proiecteap");
        int po;
        if(pos == true) po = 1;
        else po = 0;
        statement.executeUpdate("INSERT INTO `proiecteap`.`soferi` (`Nume`, `POS`, `vehicul`) VALUES ('"+nume+"', '"+po+"', '"+vehicul+"');");
    }

    //Functie afisare soferi din baza de date
    public static void afisare_soferi() throws SQLException {
        statement.executeUpdate("use proiecteap");
        ResultSet Rs = statement.executeQuery("SELECT * from soferi");
        while (Rs.next()) {
            System.out.println(" Nume sofer: " + Rs.getString("Nume") + " " + " Detinerea de POS: " + Rs.getBoolean("POS") + "  Vehicul detinut: " + Rs.getString("vehicul"));
        }
    }


    //Functii inserare comanda
    public static  void inserare_comanda(int nr_comanda) throws SQLException {
        statement.executeUpdate("use proiecteap");
        statement.executeUpdate("INSERT INTO `proiecteap`.`comenzi` (`Nr_comanda`) VALUES ('"+nr_comanda+"');");
    }

    //Functie afisarea comenzilor din baza de date
    public static void afisare_comenzi() throws SQLException {
        statement.executeUpdate("use proiecteap");
        ResultSet Rs = statement.executeQuery("SELECT * from comenzi");
        while (Rs.next()) {
            System.out.println(" Numar comanda: " + Rs.getString("Nr_comanda"));
        }
    }


    //Functii inserare recenzie
    public static  void inserare_recenzie(int nr_rating,int nota,String comentariu) throws SQLException {
        statement.executeUpdate("use proiecteap");
        statement.executeUpdate("INSERT INTO `proiecteap`.`recenzii` (`Numar_rating`, `Nota`, `Comentariu`) VALUES ('"+nr_rating+"', '"+nota+"', '"+comentariu+"');");
    }

    //Functie afisarea recenzilor din baza de date
    public static void afisare_recenzi() throws SQLException {
        statement.executeUpdate("use proiecteap");
        ResultSet Rs = statement.executeQuery("SELECT * from recenzii");
        while (Rs.next()) {
            System.out.println(" Numarul recenziei: " + Rs.getInt("Numar_rating") + " " + " Nota: " + Rs.getInt("Nota") + "  Comentariu: " + Rs.getString("Comentariu"));
        }
    }


    public static void initializare() throws SQLException {
        BazeDeDate b = new BazeDeDate();
        delete_tables();
        create_tables();
        test();
    }

}
