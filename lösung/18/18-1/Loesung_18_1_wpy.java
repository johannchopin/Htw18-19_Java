/*
 *
 *
 * Loesung  W.Pauly 
 *
 *
 */


public class Loesung_18_1_wpy 
  {

   //  
   //
   //17_1.a:
   public void applyAndPrint(MyFunction myFunction, int i, int j)
     {
      for ( int lauf = i; lauf <= j; lauf++ )
        {
         System.out.println( lauf + " -> " + myFunction.apply(lauf) );
        }
     }
 
   //
   //17_1.b-ii: Fakultaet als Nested-Static-Klasse
   //
   public static class NestedFakultaet
     {
      public static int rechne(int x)
        {
          int erg = 1;
                
          for ( int i = 2; i<=x; i++ )
            {
             erg *= i;
            }
          return erg;
        }
     }
  

    public void run ()
      {

       //
       //
       // 17_1.b-ii
       // x! als anonyme Klasse
       MyFunction xFakultAnon = new MyFunction(){
                     public int apply( int x  )
                       {
                         int erg = 1;
                
                         for ( int i = 2; i<=x; i++ )
                           {
                            erg *= i;
                           }
                         return erg;
                       }
       };

       System.out.println( "\n xFakult - anonyme Klasse");
       applyAndPrint( xFakultAnon, 1, 10 );
       
       //
       //
       // 17_1.b-ii
       // x! als Lambda-Ausdruck
       MyFunction xFakult = x -> 
                                {
                                 int erg = 1;
                        
                                 for ( int i = 2; i<=x; i++ )
                                   {
                                    erg *= i;
                                   }
                                 return erg;
                                };

       System.out.println( "\n xFakult - Lambda-Ausdruck");
       applyAndPrint( xFakult, 1, 10 );


       //
       //
       // 18_1.a
       // x! als  top level class FakultaetTopLevel


       FakultaetTopLevel fakTopL = new FakultaetTopLevel();

       System.out.println( "\n xFakult - FakultaetTopLevel - Klasse");
       System.out.println( "\n als Anonymous-Class");
       applyAndPrint( new MyFunction()
                           {
                            public int apply ( int x )
                              {
                                return fakTopL.berechne(x);
                              }
                           },
                      1, 10
                    );

       
       System.out.println( "\n xFakult - FakultaetTopLevel - Klasse");
       System.out.println( "\n als Lambda-Ausdruck 1");
       applyAndPrint( x -> {
                             return fakTopL.berechne(x);
                           },
                      1, 10
                    );

       System.out.println( "\n xFakult - FakultaetTopLevel - Klasse");
       System.out.println( "\n als Lambda-Ausdruck 1.1");
       MyFunction xFakultTL = x -> 
                                   {
                                     return fakTopL.berechne(x);
                                   };
       applyAndPrint(xFakultTL, 1, 10);

       
       System.out.println( "\n xFakult - FakultaetTopLevel - Klasse");
       System.out.println( "\n als Lambda-Ausdruck 2");
       applyAndPrint(x -> fakTopL.berechne(x), 1, 10);
       

       
       System.out.println( "\n xFakult - FakultaetTopLevel - Klasse");
       System.out.println( "\n Objekt-MethodenReferenz");
      
       applyAndPrint(fakTopL::berechne, 1, 10);
               

       //
       //
       // 18_1.b
       // x! als  static nested class NestedFakultaet
       System.out.println( "\n xFakult - Static Nested - Klasse");
       System.out.println( "\n als Anonymous-Class");
       applyAndPrint( new MyFunction()
                           {
                            public int apply ( int x )
                              {
                                return NestedFakultaet.rechne(x);
                              }
                           },
                      1, 10
                    );

       
       System.out.println( "\n xFakult - Static Nested - Klasse");
       System.out.println( "\n als Lambda-Ausdruck 1");
       applyAndPrint( x -> {
                             return NestedFakultaet.rechne(x);
                           },
                      1, 10
                    );

       System.out.println( "\n xFakult - Static Nested - Klasse");
       System.out.println( "\n als Lambda-Ausdruck 1.1");
       MyFunction xFakultNest = x -> 
                                   {
                                     return NestedFakultaet.rechne(x);
                                   };
       applyAndPrint(xFakultNest, 1, 10);
       

       System.out.println( "\n xFakult - Static Nested - Klasse");
       System.out.println( "\n als Lambda-Ausdruck 2");
       applyAndPrint(x -> NestedFakultaet.rechne(x), 1, 10);
       


       System.out.println( "\n xFakult - Static Nested - Klasse");
       System.out.println( "\n statische MethodenReferenz");
       applyAndPrint(NestedFakultaet::rechne, 1, 10);
              
     }
 
         
     
   public static void main(String[] args)
     {
       Loesung_18_1_wpy test = new Loesung_18_1_wpy();
       test.run();
    }
    
  }
