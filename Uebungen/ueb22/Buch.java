/**
 * Unterklasse Buch der Obereklasse Artikel
 *
 * @author Alexandre Guidoux && Johann Chopin
 * @version 1.0
 */
public class Buch extends Artikel
{
   private String autor;
   private String verlag;
   
   /**
    * @see Artikel#Artikel(int, String, int, double)
    * @param autor Autor des Buchs
    * @param verlag Verlag des Buchs
    */
   Buch(int nummer, String titel, int bestand, double preis, String autor, String verlag){
       super(nummer, titel, bestand, preis);
       this.autor = autor;
       this.verlag = verlag;
   }
      
   public String getAuthor(){
       return this.autor;
   }
   
   public String getBeschreibung(){
       return this.autor + " : " + this.bezeichnung;
   }
}
