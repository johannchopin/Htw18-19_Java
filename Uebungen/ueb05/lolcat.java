
/**
 * Décrivez votre classe lolcat ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class lolcat
{
  public static void main(String[] args){
    int[] tab = new int[10];
    System.out.println(tab.length);
    for(int i = 0; i < tab.length; i++){
      tab[i] = i;
    }
    for(int i = 5; i < tab.length-1; i++){
      tab[i] = tab[i+1];
    }
    tab[tab.length-1] = 0;

    String str = new String();
    for(int i = 0; i < tab.length; i++){
      str += "Index: " + i + " --> " + tab[i] + "\n";  
    }
    System.out.println(str);
  }
}
