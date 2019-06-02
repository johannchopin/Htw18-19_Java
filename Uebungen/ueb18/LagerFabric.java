import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Random;

/**
 * Useful to manipulate the LagerDialog
 *
 * @author  Alexandre Guidoux
 * @version 1.0
 */
public class LagerFabric
{
    private Artikel artikel;
    private Buch buch; 
    private CD cd; 
    private Video video;
    private int maxSize;
    Random randomThat;
    
    /**
     * Create a full Lager with products
     */
    public LagerFabric(int size)
    {
        randomThat = new Random();
        maxSize = size;
    }
    
    public ArtikelLager generateLager(){
                int lagerSize = Helpers.max(randomThat.nextInt(this.maxSize), 10);
        int itemsInStore = Helpers.max(randomThat.nextInt(lagerSize), 1);
        int dice; // Store a random number like a dice
        int typeNumber = 3; // Buch, CD, Video + Artikel as default
        
        ArtikelLager magicStore = new ArtikelLager(lagerSize);
        Artikel currentArtikel;
        for(int i=0; i < itemsInStore; i++){
            dice = randomThat.nextInt(typeNumber);
            switch(dice){    
                case 0:
                    currentArtikel = choiceArtikel(library);
                    break;
                
                case 1:
                    currentArtikel = choiceArtikel(musik);
                    break;
                    
                case 2:
                    currentArtikel = choiceArtikel(videotek);
                    break;
                    
                default:
                    currentArtikel = choiceArtikel(newspapers);
            }
            try{
                magicStore.anlegen(currentArtikel);
            } catch(Exception e){
                i--;
            }
        } 
        return magicStore;
    }
    
    /**
     * Choice a random artikel in the store, then remove this article
     */
    private Artikel choiceArtikel(Artikel[] store){
        return store[randomThat.nextInt(store.length)];
    }
    private Artikel[] removeElement(Artikel[] tab, int itemIndex){
        Artikel[] newTab = new Artikel[tab.length-1];
        for(int i=0; i < itemIndex; i++)
            newTab[i] = tab[i];
        for(int i = itemIndex+1; i < tab.length -1; i++)
            newTab[i] = tab[i];
        return newTab;  
    }
    
    // Pattern : nummer bezeichnung bestand preis
    private Artikel[] newspapers = {
        new Artikel(1000, "Schuhe", 10, 20),
        new Artikel(1001, "Hose", 10, 42),
        new Artikel(1002, "Jacke", 10, 64),
        new Artikel(1003, "Schtrumpf", 10, 38),
        new Artikel(1004, "NotizHeft", 20, 27),
        new Artikel(1005, "Stift", 30, 20),
    };
    // Pattern : nummer bezeichnung bestand preis autor verlag
    private Buch[] library = {
        new Buch(2000, "Harry Potter und der Stein der Weisen", 10, 10, "J.K. Rowling", "unbekannt"),
        new Buch(2001, "Harry Potter und die Kammer des Shreckens", 10, 11, "J.K. Rowling", "unbekannt"),
        new Buch(2002, "Harry Potter und der Gefangene von Askaban", 10, 12, "J.K. Rowling", "unbekannt"),
        new Buch(2003, "Harry Potter und der Feuerkelch", 10, 13, "J.K. Rowling", "unbekannt"),
        new Buch(2004, "Harry Potter und der Orden des Phoenix", 10, 14, "J.K. Rowling", "unbekannt"),
        new Buch(2005, "Harry Potter und der der Halbblutprinz", 10, 15, "J.K. Rowling", "unbekannt"),
        new Buch(2006, "Harry Potter und die Heiligtuemer des Todes", 10, 16, "J.K. Rowling", "unbekannt"),
        new Buch(2007, "Datenbankentwicklung lernernen mit SQL Server 2007", 10, 17, "Robert Panther", "O'REILLY"),
    };
    // Pattern : nummer bezeichnung bestand preis interpret anzahlMusikTitel
    private CD[] musik = {
        new CD(3001, "Thunder", 10, 50, "Imagine Dragons", 14),
        new CD(3002, "Believer", 10, 51, "Imagine Dragons", 14),
        new CD(3003, "Bad Liar", 10, 52, "Imagine Dragons", 14),
        new CD(3004, "Radioactive", 10, 53, "Imagine Dragons", 14),
        new CD(3005, "Whatever It Takes", 10, 54, "Imagine Dragons", 14),
        new CD(3006, "Venom Theme", 10, 55, "Eminem", 14),
        new CD(3007, "Darkside", 10, 56, "Alan Walker", 14),
        new CD(3008, "Faded", 10, 57, "Alan Walker", 14),
        new CD(3009, "Alone", 10, 58, "Alan Walker", 14),
        new CD(3010, "The Spectre", 10, 59, "Alan Walker", 14),
    };
    // Pattern : nummer, bezeichnung bestand preis spieldauer erscheinungsjahr
    private Video[] videotek = {
        new Video(4001, "Lolcat", 3, 84, 66.6, 2014),
        new Video(4001, "BattleStar Galactica S01E0.mkv", 3, 85, 66.6, 2002),
        new Video(4008, "BattleStar Galactica S01E1.mkv", 3, 86, 66.6, 2002),
        new Video(4015, "BattleStar Galactica S01E2.mkv", 3, 87, 66.6, 2002),
        new Video(4022, "BattleStar Galactica S01E3.mkv", 3, 88, 66.6, 2002),
        new Video(4029, "BattleStar Galactica S01E4.mkv", 3, 89, 66.6, 2002),
        new Video(4036, "BattleStar Galactica S01E5.mkv", 3, 90, 66.6, 2002),
        new Video(4043, "BattleStar Galactica S01E6.mkv", 3, 91, 66.6, 2002),
        new Video(4050, "BattleStar Galactica S01E7.mkv", 3, 92, 66.6, 2002),
        new Video(4057, "BattleStar Galactica S01E8.mkv", 3, 96, 66.6, 2002),
        new Video(4064, "BattleStar Galactica S01E9.mkv", 3, 97, 66.6, 2002),
        new Video(4071, "BattleStar Galactica S01E10.mkv", 3, 99, 66.6, 2002),
        new Video(4078, "BattleStar Galactica S01E11.mkv", 3, 100, 66.6, 2002),
        new Video(4085, "BattleStar Galactica S01E12.mkv", 3, 101, 83.6, 2002),
        new Video(4092, "BattleStar Galactica S01E13.mkv", 3, 104, 66.6, 2002),
        new Video(4099, "BattleStar Galactica S01E14.mkv", 3, 108, 66.6, 2002),
        new Video(4106, "BattleStar Galactica S01E15.mkv", 3, 110, 66.6, 2002),
        new Video(4113, "BattleStar Galactica S01E16.mkv", 3, 112, 66.6, 2002),
        new Video(4120, "BattleStar Galactica S01E17.mkv", 3, 114, 66.6, 2002),
        new Video(4127, "BattleStar Galactica S01E18.mkv", 3, 117, 66.6, 2002),
        new Video(4134, "BattleStar Galactica S01E19.mkv", 3, 119, 66.6, 2002),
        new Video(4002, "BattleStar Galactica S02E0.mkv", 3, 124, 66.6, 2004),
        new Video(4009, "BattleStar Galactica S02E1.mkv", 3, 121, 66.6, 2004),
        new Video(4016, "BattleStar Galactica S02E2.mkv", 3, 126, 66.6, 2004),
        new Video(4023, "BattleStar Galactica S02E3.mkv", 3, 130, 66.6, 2004),
        new Video(4030, "BattleStar Galactica S02E4.mkv", 3, 129, 66.6, 2004),
        new Video(4037, "BattleStar Galactica S02E5.mkv", 3, 127, 66.6, 2004),
        new Video(4044, "BattleStar Galactica S02E6.mkv", 3, 132, 66.6, 2004),
        new Video(4051, "BattleStar Galactica S02E7.mkv", 3, 131, 66.6, 2004),
        new Video(4058, "BattleStar Galactica S02E8.mkv", 3, 138, 66.6, 2004),
        new Video(4065, "BattleStar Galactica S02E9.mkv", 3, 134, 66.6, 2004),
        new Video(4072, "BattleStar Galactica S02E10.mkv", 3, 95, 66.6, 2004),
        new Video(4079, "BattleStar Galactica S02E11.mkv", 3, 94, 66.6, 2004),
        new Video(4086, "BattleStar Galactica S02E12.mkv", 3, 94, 66.6, 2004),
        new Video(4093, "BattleStar Galactica S02E13.mkv", 3, 94, 66.6, 2004),
        new Video(4100, "BattleStar Galactica S02E14.mkv", 3, 94, 66.6, 2004),
        new Video(4107, "BattleStar Galactica S02E15.mkv", 3, 96, 66.6, 2004),
        new Video(4114, "BattleStar Galactica S02E16.mkv", 3, 94, 66.6, 2004),
        new Video(4121, "BattleStar Galactica S02E17.mkv", 3, 94, 66.6, 2004),
        new Video(4128, "BattleStar Galactica S02E18.mkv", 3, 105, 66.6, 2004),
        new Video(4135, "BattleStar Galactica S02E19.mkv", 3, 99, 66.6, 2004),
        new Video(4003, "BattleStar Galactica S03E0.mkv", 3, 89, 66.6, 2006),
        new Video(4010, "BattleStar Galactica S03E1.mkv", 3, 85, 66.6, 2006),
        new Video(4017, "BattleStar Galactica S03E2.mkv", 3, 85, 66.6, 2006),
        new Video(4024, "BattleStar Galactica S03E3.mkv", 3, 85, 66.6, 2006),
        new Video(4031, "BattleStar Galactica S03E4.mkv", 3, 85, 66.6, 2006),
        new Video(4038, "BattleStar Galactica S03E5.mkv", 3, 85, 66.6, 2006),
        new Video(4045, "BattleStar Galactica S03E6.mkv", 3, 85, 66.6, 2006),
        new Video(4052, "BattleStar Galactica S03E7.mkv", 3, 85, 66.6, 2006),
        new Video(4059, "BattleStar Galactica S03E8.mkv", 3, 85, 66.6, 2006),
        new Video(4066, "BattleStar Galactica S03E9.mkv", 3, 84, 66.6, 2006),
        new Video(4073, "BattleStar Galactica S03E10.mkv", 3, 84, 66.6, 2006),
        new Video(4080, "BattleStar Galactica S03E11.mkv", 3, 84, 66.6, 2006),
        new Video(4087, "BattleStar Galactica S03E12.mkv", 3, 84, 66.6, 2006),
        new Video(4094, "BattleStar Galactica S03E13.mkv", 3, 84, 66.6, 2006),
        new Video(4101, "BattleStar Galactica S03E14.mkv", 3, 84, 66.6, 2006),
        new Video(4108, "BattleStar Galactica S03E15.mkv", 3, 84, 66.6, 2006),
        new Video(4115, "BattleStar Galactica S03E16.mkv", 3, 84, 66.6, 2006),
        new Video(4122, "BattleStar Galactica S03E17.mkv", 3, 84, 66.6, 2006),
        new Video(4129, "BattleStar Galactica S03E18.mkv", 3, 84, 66.6, 2006),
        new Video(4136, "BattleStar Galactica S03E19.mkv", 3, 84, 66.6, 2006),
        new Video(4004, "BattleStar Galactica S04E0.mkv", 3, 84, 66.6, 2008),
        new Video(4011, "BattleStar Galactica S04E1.mkv", 3, 84, 66.6, 2008),
        new Video(4018, "BattleStar Galactica S04E2.mkv", 3, 84, 66.6, 2008),
        new Video(4025, "BattleStar Galactica S04E3.mkv", 3, 84, 66.6, 2008),
        new Video(4032, "BattleStar Galactica S04E4.mkv", 3, 84, 66.6, 2008),
        new Video(4039, "BattleStar Galactica S04E5.mkv", 3, 84, 66.6, 2008),
        new Video(4046, "BattleStar Galactica S04E6.mkv", 3, 84, 66.6, 2008),
        new Video(4053, "BattleStar Galactica S04E7.mkv", 3, 84, 66.6, 2008),
        new Video(4060, "BattleStar Galactica S04E8.mkv", 3, 84, 66.6, 2008),
        new Video(4067, "BattleStar Galactica S04E9.mkv", 3, 84, 66.6, 2008),
        new Video(4074, "BattleStar Galactica S04E10.mkv", 3, 70, 66.6, 2008),
        new Video(4081, "BattleStar Galactica S04E11.mkv", 3, 72, 66.6, 2008),
        new Video(4088, "BattleStar Galactica S04E12.mkv", 3, 67, 66.6, 2008),
        new Video(4095, "BattleStar Galactica S04E13.mkv", 3, 79, 66.6, 2008),
        new Video(4102, "BattleStar Galactica S04E14.mkv", 3, 80, 66.6, 2008),
        new Video(4109, "BattleStar Galactica S04E15.mkv", 3, 79, 66.6, 2008),
        new Video(4116, "BattleStar Galactica S04E16.mkv", 3, 77, 66.6, 2008),
        new Video(4123, "BattleStar Galactica S04E17.mkv", 3, 79, 66.6, 2008),
        new Video(4130, "BattleStar Galactica S04E18.mkv", 3, 91, 66.6, 2008),
        new Video(4137, "BattleStar Galactica S04E19.mkv", 3, 82, 66.6, 2008),
    };
}
