
/**
 * A simple Person with first and last name
 *
 * @author Guidoux Alexandre
 * @version 1.0
 */
public class Person
{
    protected String vorname, nachname;
    
    public Person(String vorname, String nachname)
    {
        vorname = vorname.trim();
        nachname = nachname.trim();
        h.checkArgs(vorname.length() > 0, "The firstname must contain characters");
        h.checkArgs(nachname.length() > 0, "The lastname must contain characters");
        this.vorname = vorname;
        this.nachname = nachname;
    }

    public String toString(){
        return new String(this.vorname + " " + this.nachname);
    }
}
