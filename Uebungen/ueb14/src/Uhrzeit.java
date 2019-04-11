/**
 * Use this class as timestamp (hours and minuten)
 *
 * @author Guidoux Alexandre
 * @version 1.0
 */
public class Uhrzeit
{
    public int stunde, minute;
    
    /**
     * Create a Uhrzeit object with hours and minutes
     * @param stunde 0 to 23
     * @param minute 0 to 59
     */
    public Uhrzeit(int stunde, int minute){
        h.checkArgs(0 <= stunde && stunde < 24, "The hour must be between 0 and 23");
        h.checkArgs(0 <= minute && minute < 60, "The minutes must be between 0 and 59");
        this.stunde = stunde;
        this.minute = minute;
    }
    
    public String toString(){
        return new String(this.stunde + ":" + this.minute + " Uhr"); 
    }
}
