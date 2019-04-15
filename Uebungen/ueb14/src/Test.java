
/**
 * Ermoeglicht die Lager-Klasse zu benutzen
 *
 * ! Code ruf_artikel_darstellung
 *
 * @author Alexandre Guidoux && Johann Chopin
 * @version 1.0
 */
public class Test
{    

    /**
     * Main-Methode : Erzeuget des LagerDialog-Objekts und start der
     * Hauptschleife.
     */
    public static void main(String[] args) {
        Mitarbeiter m1 = new Mitarbeiter("Max", "Mustermann", "max@htwsaar.de");
        Mitarbeiter m2 = new Mitarbeiter("John", "Doe", "john@htwsaar.de");

        Raum r = new Raum(18, 0, 1);
        Raum r1 = new Raum(18,0,1);
        Raum r2 = new Raum(2,1,9);
        Raum r3 = new Raum(2,1,10);

        m1.reserviere(r1, new Uhrzeit(12, 30), new Uhrzeit(14, 30), "VOOP");
        m1.reserviere(r2, new Uhrzeit(14, 30), new Uhrzeit(16, 30), "WebTech");
        m2.reserviere(r2, new Uhrzeit(12, 30), new Uhrzeit(13, 30), "Prog II");
        m2.reserviere(r3, new Uhrzeit(10, 30), new Uhrzeit(11, 30), "ITM");

        System.out.println(m1);
        System.out.println("---");
        System.out.println(r);
        System.out.println("---");
        System.out.println(r1);


        System.out.println("\n" + ">> Not valid hour in 'Uhrzeit' :");
        try {
            Uhrzeit u = new Uhrzeit(-12, 54);
        } catch(Exception e) {
            System.out.println("Exception catched : " + e);
        }
        
        System.out.println("\n" + ">> Not valid minutes in 'Uhrzeit' :");
        try {
            Uhrzeit u = new Uhrzeit(12, -54);
        } catch(Exception e) {
            System.out.println("Exception catched : " + e);
        }
        
        System.out.println("\n" + ">> Not valid Gebaude in 'Raum' :");
        try {
            Raum rTest = new Raum(-18, 0, 1);
        } catch(Exception e) {
            System.out.println("Exception catched : " + e);
        }

        System.out.println("\n" + ">> Not valid Nummer in 'Raum' :");
        try {
            Raum rTest = new Raum(18, -1, 1);
        } catch(Exception e) {
            System.out.println("Exception catched : " + e);
        }

        System.out.println("\n" + ">> testest Not valid Etage in 'Raum' :");
        try {
            Raum rTest = new Raum(18, 1, -1);
        } catch(Exception e) {
            System.out.println("Exception catched : " + e);
        }
        

        System.out.println("\n" + ">> 'Mitarbeiter' without 'firstname' :");
        try {
            Mitarbeiter mTest = new Mitarbeiter("", "", "");
        } catch(Exception e) {
            System.out.println("Exception catched : " + e);
        }


        System.out.println("\n" + ">> 'Mitarbeiter' without 'lastname' :");
        try {
            Mitarbeiter mTest = new Mitarbeiter("test", "", "");
        } catch(Exception e) {
            System.out.println("Exception catched : " + e);
        }


        System.out.println("\n" + ">> 'reservierung' without 'Bemerkung' :");
        try {
           m1.reserviere(r1, new Uhrzeit(12, 30), new Uhrzeit(14, 30), "");
        } catch(Exception e) {
            System.out.println("Exception catched : " + e);
        }
    }

}
