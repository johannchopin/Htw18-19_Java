/*
 *
 *
 * Loesung  W.Pauly 
 *
 *
 */


//
//
//
//1.b: Fakultaet als Top-Level-Klasse
//
public class FakultaetTopLevel
  {
    public int berechne(int x)
      {
        int erg = 1;

        for ( int i = 2; i<=x; i++ )
          {
            erg *= i;
          }

        return erg;
      }
  }

