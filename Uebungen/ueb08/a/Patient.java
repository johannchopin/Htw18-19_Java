import java.util.regex.Pattern;
/**
 * A simple patient with name and id
 *
 * @author Alexandre Guidoux
 * @version 1.0
 */
public class Patient
{
    private final static String NUMMER_ERROR = 
                        "Der nummer muss > 0 sein.";
    private final static String NAME_ERROR = 
                        "Der Name muss wie \"Name, Vorname\" dargestellt sein.";
    private final static Pattern NAME_FORMAT = 
                         Pattern.compile("\\p{L}{2,}, \\p{L}{2,}");
    
    private int    nummer;
    private String name;
                         
    Patient(int nummer, String name){
        setNummer(nummer);
        setName(name);
    }
    
    private void setNummer(int nummer){
        FuncHelpers.checkArguments(nummer > 0, NUMMER_ERROR);
        this.nummer = nummer;
    }
    
    private void setName(String name){
        FuncHelpers.checkArguments(NAME_FORMAT.matcher(name).matches(), 
                                   NAME_ERROR);
        this.name = name;
    }
    
    public int getNummer(){
        return this.nummer;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String toString(){
        return getNummer() + "    " + getName();
    }
}
