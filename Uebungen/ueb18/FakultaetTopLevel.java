/**
 * Top-level class
 * 
 * @author W. Pauly
 * @version 1.0
 */
public class FakultaetTopLevel
  {
    public int berechne(int x)
      {
        int erg = 1;
        for ( int i = 2; i<=x; i++ ){
            erg *= i;
        }
        return erg;
      }
  }