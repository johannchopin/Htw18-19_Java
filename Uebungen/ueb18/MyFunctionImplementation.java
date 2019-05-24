
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
}