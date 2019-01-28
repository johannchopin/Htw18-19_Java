
/**
 * A simple Person class
 *
 * @author Alexandre Guidoux
 * @version 1.0
 */
public class Person
{
    /**
     * Person auf die Standardausgabe ausgeben
     *
     */
    public Person(String name, String vorname){
        Helpers.checkArgs(!(name == null), 
                          "Der Name ist nicht definiert (NullPointerException)");
        Helpers.checkArgs(!(name.isEmpty()), 
                          "Der Name darf nicht leer sein.");
        Helpers.checkArgs(!(vorname == null), 
                          "Der Vorname ist nicht definiert (NullPointerException)");
        Helpers.checkArgs(!(vorname.isEmpty()), 
                          "Der Vorname darf nicht leer sein.");
        this.name = name;
        this.vorname = vorname;
    } 

    public void ausgeben() {
        System.out.print(name + ", " + vorname);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getName() {
        return this.name;
    }

    public String getVorname() {
        return this.vorname;
    }
    
    public String toString() {
        return this.name + ", " + this.vorname;
    }
    
    private String name;
    private String vorname;
}
