import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.util.ArrayList;
import java.util.List;

public class DuLauncher {
    @Option(name = "-h", usage = "Normal format")
    private boolean format = false;

    @Option(name = "-c", usage = "Total size")
    private boolean sum = false;

    @Option(name = "-si", usage = "Another number system")
    private boolean numSyst = false;

    @Argument(metaVar = "fileN", usage = "Input file names")
    private String[] fileN;

    public static List list = new ArrayList();

    public static void main(String[] args) {
        new DuLauncher().launch(args);
    }

    private void launch(String[] args) {
        CmdLineParser parser = new CmdLineParser(this);

        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
            System.err.println("java -jar Example.jar -k file");
            parser.printUsage(System.err);
            return;
        }

        Du du = new Du(format, sum, numSyst);
        du.outWriter(du.answer(fileN));
        System.out.println("Конец программы.");
        list = du.answer(fileN);;
    }

}
