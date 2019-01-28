import java.util.Scanner;
import java.util.InputMismatchException;
/**
 * Ein paar Methoden, um die Scanner Methoden einfacher zu benutzen
 *
 * @author Alexandre Guidoux
 * @version 1.0
 */
public class ScannerHelpers
{
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
                String rv = sc.next();
                return rv;
            } catch(InputMismatchException e){
                sc.nextLine();
                System.out.println(e + ": eine Zeichenkette ist erwartet.\n");
            }
        } 
    }
    
    /**
     * Return True if the first character match the given character
     * @param is_true character which should match
     */
    public static boolean isInputTrue(Scanner sc, String nachricht, char is_true){
        while(true){
            System.out.println(nachricht);
            try{
                char read = sc.next().charAt(0);
                return read == is_true;
            } catch (InputMismatchException e){
                sc.nextLine();
                System.out.println(e + ": ein character ist erwartet\n");
            }
        }
    }
    /**
     * Return True if the first character is 'j'
    */
    public static boolean isInputTrue(Scanner sc, String nachricht){
        return isInputTrue(sc, nachricht, 'j');
    }
}
