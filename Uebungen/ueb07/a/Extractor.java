import java.util.regex.Pattern;
import java.util.regex.Matcher; 
import java.util.Arrays;

/**
 * Extract link from a HTML-Datei
 *
 * @author Alexandre Guidoux
 * @version 1.0
 */
public class Extractor
{
    private static final Pattern REGEX = Pattern.compile(
              "<a href=\"(?<url>.+?)\".*?>(?<description>.*?)</a>");
    
    /**
     * Find all content of href tags and the text inside a tag.
     * 
     * @return array with
     *         * array[0] store the urls as String
     *         * array[1] store the descriptions as String
     */
    private static String[][] findLinksAndDescriptions(String content){
        String[] urls = new String[0]; 
        String[] desc = new String[0];
        Matcher extract = REGEX.matcher(content);
        
        while(extract.find()){
            urls = ArrayHelpers.insertEnd(urls, extract.group("url"));
            desc = ArrayHelpers.insertEnd(desc, extract.group("description"));
        }
        return new String[][] {urls, desc};
    }
    
    /**
     * Print the Array as requested : <url>: <description>\n
     * 
     * @param 2 Arrays in one : array[0] is the urls 
     *          and array[1][] is the descriptions
     */
    public static void printUrls(String[][] urlInfos){
        int maxLengthDescriptions = ArrayHelpers.max(urlInfos[1]);
        
        for(int i=0; i < urlInfos[0].length; i++){
            System.out.printf("%-"+maxLengthDescriptions+"s %s\n", 
                              urlInfos[0][i] + ":", 
                              urlInfos[1][i]);
        }
    }
    
    /**
     * Main methode
     * Steps are : 
     * * Get the content in a string (from file or system.in)
     * * Find all urls and descriptions
     * * Print these to System.out
     */
    public static void main(String[] argv){
        String content;
        if(argv.length == 0)
            content = InputToString.bashHandler();
        else
            content = InputToString.fileHandler(argv[0]);
          
        printUrls(findLinksAndDescriptions(content));
    }
}
