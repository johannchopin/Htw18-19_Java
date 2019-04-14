/**
 * Use this class as timestamp (hours and minuten)
 *
 * @author Guidoux Alexandre
 * @version 1.0
 */
public class Uhrzeit implements Comparable<Uhrzeit>
{
    public int stunde, minute;
    private static int HoursToMinutes = 60;
    
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
    
    private int getStunde() {
    	return this.stunde;
    }
    
    private int getMinute() {
    	return this.minute;
    }			
    
    public String toString(){
        return new String(this.stunde + ":" + this.minute + " Uhr"); 
    }
    
    /**
     * Compare the sum of the minutes of the two Uhrzeit objects
     * @return int a negative integer, zero, or a positive integer as this Uhrzeit is less than, equal to, or greater than the specified Uhrzeit.
     */
    @Override
    public int compareTo(Uhrzeit other) {
    	return Integer.compare(this.getStunde()  * HoursToMinutes + this.getMinute(),
    						   other.getStunde() * HoursToMinutes + other.getMinute());
    }
}

