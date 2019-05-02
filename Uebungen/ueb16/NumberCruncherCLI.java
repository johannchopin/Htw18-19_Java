import org.apache.commons.cli.Options;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.HelpFormatter;

/**
 * A CLI for the object NumberCruncher
 *
 * @author Alexandre Guidoux
 * @version 1.0
 */
public class NumberCruncherCLI
{
    public static Options setOptions(Options options){ 
        options.addOption(Option.builder("a")
            .longOpt("auto")
            .desc("Run the example")
            .required(false)
            .build());

        options.addOption(Option.builder("h")
            .longOpt("help")
            .desc("Print the help")
            .required(false)
            .build());

        options.addOption(Option.builder("l")
            .longOpt("length")
            .desc("Length of the generated array (integer)")
            .required(false)
            .numberOfArgs(1)
            .type(int.class)
            .build());

        options.addOption(Option.builder("o")
            .longOpt("operation")
            .desc("Operation applied on the generated array.\nValues are : sum, swirl, divide, substract and average")
            .required(false)
            .hasArgs()
            .build());

        options.addOption(Option.builder("s")
            .longOpt("seed")
            .desc("Use the given seed (integer)")
            .required(false)
            .numberOfArgs(1)
            .type(int.class)
            .build());

        options.addOption(Option.builder("v")
            .longOpt("verbose")
            .desc("Print the array after each operation")
            .required(false)
            .build());

        return options;
    }

    // TODO: implement run method to start NUmberCruncher
    // TODO: get informations from CLI,
    public static void main(String[] args){
        Options options = new Options();
        options = setOptions(options);

        HelpFormatter formatter = new HelpFormatter();

        CommandLineParser parser = new DefaultParser();
        try{
            CommandLine cmd = parser.parse(options, args);

            if(cmd.hasOption("help")){
                formatter.printHelp("java NumberCruncherCLI", 
                    "", options, "", true);
                System.exit(0);
            }
            
            if(cmd.hasOption("l"))
                System.out.println("Got -l");
            
        } catch(ParseException exp){
            System.err.println("Parsing failed. Error : " + exp.getMessage());
            System.out.println("Use --help to get more informations.");
            System.exit(1);
        }
    }
}
