// File importations
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.charset.Charset;
// IO Imports
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
// Toolkit imports
import java.util.Collections;
import java.lang.StringBuilder;

public class Helpers{

    public static void check(boolean condition, String message) throws IllegalArgumentException{
        if(!condition)
            throw new IllegalArgumentException(message);
    }

    /**
    * @param filename a readable filename 
    * @return content of the file as String
    */
    public static String readFile(String filename) throws IOException {
        BufferedReader buffer = new BufferedReader(
                                    new FileReader(filename));

        String line = "";
        String separator = System.lineSeparator();
        StringBuilder sb = new StringBuilder();

        while((line = buffer.readLine()) != null){
            sb.append(line).append(separator);
        } 

        buffer.close();
        return sb.substring(0, sb.length()-1); // Remove the last lineSeparator
    }

    /**
    * Write the string in the specified file.
    * If the file exist, it will be overwritten. If it doesn't, it will be created.  
    */
    public static void writeInFile(String filename, String s) throws IOException {
        Files.write(Paths.get(filename), s.getBytes());
    }
    /**
    * Append the string <code>s</code> at the end of the file <code>filename</code>
    */
    public static void appendInFile(String filename, String s) throws IOException {
        Files.write(Paths.get(filename), s.getBytes(), StandardOpenOption.APPEND);
    }

    /**
    * Sum all the element of a long[] array
    */
    public static long sum(long[] tab){
        long acc = 0;
        for(long e: tab)
            acc += e;
        return acc;
    }

    /**
    * Use the sum method
    * @return the mean of the sum of the elements in the arrays
    */
    public static long mean(long[] tab){
        return sum(tab) / tab.length;
    }

    /**
    * Note that there is a String.repeat(n) method in Java 11. 
    * Repeat <code>n</code> times the string <code>s</code>
    * @return s * n 
    */
    public static String repeat(String s, int n){
        return String.join("", Collections.nCopies(n, s));
    }

    /**
    * @return the comma-separated values in the array
    */
    public static String longArrToString(long[] arr){
        StringBuilder sb = new StringBuilder();
        for(long el: arr)
            sb.append(el).append(",");
        return sb.substring(0, sb.length()-1).toString();
    }
}