package a;

import org.junit.*;
import static org.junit.Assert.*;



/**
 * Here are some Junit test
 *
 * @author Chopin Johann
 * @version 1.0
 */
public class LagerTest {
    private Lager lager1;
    
    @Before
    public void setUp() {
        lager1 = new Lager(1234);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testNegativerLagerGrosse() {
       Lager lagerTest = new Lager(-1234);
    }
     
    @Test (expected = ArrayStoreException.class)
    public void testUnbestimmtArtikelLoeschen(){
        lager1.loeschen(4948);
    }
     
    @Test (expected = ArrayStoreException.class)
    public void testUnbestimmtArtikelZusatzt(){
        lager1.artikelZugang(4948, 49);
    }
     
    @Test (expected = ArrayStoreException.class)
    public void testUnbestimmtArtikelloeschen(){
        lager1.loeschen(4949);
    }
     
    @Test (expected = ArrayStoreException.class)
    public void testUnbestimmtArtikelGet(){
        lager1.getArtikel(4949);
    }
     
    @Test
    public void testArtikelZusatzt(){
        lager1.anlegen(4949, "Unicorn", 49);
        lager1.artikelZugang(4949, 1);
        assertEquals(lager1.getArtikel(4949).getBestand(), 50);
    }
     
    @Test
    public void testArtikelAbsatzt(){
        lager1.anlegen(4948, "Unicorn", 1);
        lager1.artikelAbgang(4948, 1);
        assertEquals(lager1.getArtikel(4948).getBestand(), 0);
    }
     
    @Test
    public void testArtikelGet(){
        Artikel artikelTest = new Artikel(4949, "Unicorn", 0, 49.0);
        assertEquals(artikelTest.toString(), "Artikel: 4949 Bezeichnung: Unicorn Bestand: 0 Preis : 49.0");
    }
     
    @Test
    public void testArtikelPreisAndern(){
        lager1.anlegen(4949, "Unicorn", 0, 49.0);
        lager1.artikelPreisAendern(4949, 100.0);
        System.out.println(lager1.getArtikel(4949).getPreis());
        double artikelPreis = lager1.getArtikel(4949).getPreis();
        assertEquals(artikelPreis, 98.0, 0.0001);
    }



}
