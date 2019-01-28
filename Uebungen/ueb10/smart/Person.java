
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
        return name;
    }

    public String getVorname() {
        return vorname;
    }
    
    public String toString() {
        return name + ", " + vorname;
    }
    
    private String name;
    private String vorname;
}
