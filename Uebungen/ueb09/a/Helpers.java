import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * nuetzilche Methoden fuer die Lager-und Artikel Klassen.
 *
 * @author Alexandre Guidoux
 * @version 1.0
 */
public class Helpers
{   
    // error constants
    public final static int ILLEGAL_ARGUMENT_EXCEPTION = 1;
    public final static int ARRAY_OUT_OF_BOUND_EXCEPTION = 2;
   
    public static void check(boolean bedigung, String nachricht) {
        check(bedigung, nachricht, ILLEGAL_ARGUMENT_EXCEPTION);
    }
    public static void check(boolean bedigung, String nachricht, int exceptionId){
        if (!bedigung){
            switch(exceptionId){
                case ILLEGAL_ARGUMENT_EXCEPTION:
                    throw new IllegalArgumentException(nachricht);
                
                case ARRAY_OUT_OF_BOUND_EXCEPTION:
                    throw new ArrayIndexOutOfBoundsException(nachricht);
            }
        }
    }
    
    /*
     * SCANNER Helpers
     */
    public static int readInt(Scanner sc, String nachricht){
        while(true){
            System.out.println(nachricht);
            try{
                int rv = sc.nextInt(); sc.nextLine();
                return rv;
            } catch(InputMismatchException e){
                sc.nextLine();
                System.out.println(e + " : Ein Integer ist erwartet.\n");
            }
        }
    }
    
    public static double readDouble(Scanner sc, String nachricht){
        while(true){
            System.out.println(nachricht);
            try{
                double rv = sc.nextDouble(); sc.nextLine();
                return rv;
            } catch(InputMismatchException e){
                sc.nextLine();
                System.out.println(e + ": ein Dezimalzahl ist erwartet.\n");
            }
        }
    }
    
    public static String readLine(Scanner sc, String nachricht){
        while(true){
            System.out.println(nachricht);
            try{
                String rv = sc.nextLine();
                return rv;
            } catch(InputMismatchException e){
                sc.nextLine();
                System.out.println(e + ": eine Zeichenkette ist erwartet.\n");
            }
        } 
    }
    
    public static boolean isInputTrue(Scanner sc, String nachricht, char is_true){
        while(true){
            System.out.println(nachricht);
            try{
                char read = sc.nextLine().charAt(0);
                return read == is_true;
            } catch (InputMismatchException e){
                sc.nextLine();
                System.out.println(e + ": ein character ist erwartet\n");
            }
        }
    }
    public static boolean isInputTrue(Scanner sc, String nachricht){
        return isInputTrue(sc, nachricht, 'j');
    }
    
    public static String repeat(String s, int n){
        return new String(new char[n]).replace("\0", s);
    }
    
    public static int max(int... integers){
        int bestSoFar = Integer.MIN_VALUE;
        for(int integer: integers){
            if(integer > bestSoFar)
                bestSoFar = integer;
        }
        return bestSoFar;
    }
}
