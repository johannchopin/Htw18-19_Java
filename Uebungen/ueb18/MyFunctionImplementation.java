
/**
 * Implement MyFunction
 *
 * @author W.Pauly
 * @version 1.0
 */
public class MyFunctionImplementation
{
   public void applyAndPrint(MyFunction myFunction, int i, int j)
   {
      for (int lauf = i; lauf <= j; lauf++){
         System.out.println(lauf + " -> " + myFunction.apply(lauf) );
      }
   }
   
   public static class NestedFakultaet {
      public static int rechne(int x){
          int erg = 1;
          for ( int i = 2; i<=x; i++ )
            {
             erg *= i;
            }
          return erg;
      }
   }
   
   public static void run(){
       MyFunctionImplementation mf = new MyFunctionImplementation();
       FakultaetTopLevel factorial = new FakultaetTopLevel();
       
       System.out.println("Aufgabe 3.a:");
       mf.applyAndPrint(factorial::berechne, 1, 15);

       System.out.println("Aufgabe 3.b:");
       mf.applyAndPrint(NestedFakultaet::rechne, 1, 15);
   }
   
   public static void main(String[] args){
       MyFunctionImplementation.run(); 
   }
}