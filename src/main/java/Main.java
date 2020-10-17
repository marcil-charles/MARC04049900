import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    private static final String SAMPLE_CSV_FILE_PATH = "C:/exemple.csv";

    public static void main(String[] args) {


        if (args.length != 2) {
            System.out.println("Paramètre manquants");
            System.out.println("Il faut utiliser : java Main.class <fichier entrée> <fichier de sortie>");
            System.exit(0);
        }

        String fichierEntree = args[0];
        System.out.println(fichierEntree);



        }

    }

