import java.util.Scanner;
import java.lang.StringBuilder;
import java.io.File;
import java.io.FileNotFoundException;
/**
 * Convert input content into a string 
 *
 * @author Alexandre Guidoux && Johann Chopin
 * @version 1.0
 */
public class InputToString
{
    /**
     * Read the content passed into the scanner
     * 
     * @param sc Scanner with a source
     * @return content of the scanner
     */
    private static String scannerToString(Scanner sc){
        StringBuffer acc = new StringBuffer();
        while(sc.hasNextLine())
            acc.append(sc.nextLine());
        acc.trimToSize();
        return acc.toString();
    }
    
    /**
     * Used when file is passed by a pipe | or by a <
     * 
     * @return content of the file
     */
    public static String bashHandler(){
        return scannerToString(new Scanner(System.in));
    }
    
    /**
     * Try to read the file and put the content into a string.
     * If errors, return an empty string and print an error message.
     * 
     * @param filename path to the file
     * @return content of the file
     */
    public static String fileHandler(String filename){
        try{
           File inputFile = new File(filename);
           Scanner sc = new Scanner(inputFile);
           return scannerToString(sc);
        } catch(FileNotFoundException e){
           String errorMsg = e + "\n" + filename + 
                        " not found (file doesn't exist or is unreadable)";
           System.out.println(errorMsg);
           return "";
        }
    }
}
