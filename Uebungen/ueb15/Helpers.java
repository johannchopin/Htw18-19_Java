import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class Helpers{

    /**
    * @param filename a readable filename 
    * @return content of the file
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

    public static long sum(long[] tab){
        long acc = 0;
        for(long e: tab)
            acc += e;
        return acc;
    }

    public static long mean(long[] tab){
        return sum(tab) / tab.length;
    }

}