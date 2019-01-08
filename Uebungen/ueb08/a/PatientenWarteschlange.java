/**
 * Ein Warteschlange mit Patienten Objekten.
 *
 * @author Alexandre Guidoux
 * @version 1.0
 */
public class PatientenWarteschlange
{
    private Queue<Patient> Patientqueue;
    private static String NUMMER_NOT_FOUND = "Der nummer wurde nicht gefunden. Abbruch.";
    
    PatientenWarteschlange(int size){
        this.Patientqueue = new Queue<Patient>(size);
    }
    
    public void neuerPatient(int nummer, String name){
        neuerPatient(new Patient(nummer, name));
    }
    public void neuerPatient(Patient p){
        this.Patientqueue.add(p);
    }
    
    public Patient derNaechsteBitte(){
        return this.Patientqueue.pop();
    }
    
    public Patient entfernePatient(int nummer){
        Patient p = new Patient(0, "Ghost");
        for(int i=0; i<this.Patientqueue.count; i++){
            if(this.Patientqueue.array[i].getNummer() == nummer){
                p = this.Patientqueue.remove(i);
                return p;
            }
        }
        FuncHelpers.checkArguments(false, NUMMER_NOT_FOUND);
        return p; // Never executed
    }
    
    public String toString(){
        return this.Patientqueue.toString("Warteliste\nPnr      Name\n");
    }
}
