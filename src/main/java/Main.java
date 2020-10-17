import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.*;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




public class Main {


    public static void main(String[] args) throws IOException {


        if (args.length != 2) {
            System.out.println("Paramètre manquants");
            System.out.println("Il faut utiliser : java Main.class <fichier entrée> <fichier de sortie>");
            System.exit(0);
        }

        String fichierEntree = args[0];
        String fichierSortie = args[1];


        //chemin absolue
        String SAMPLE_CSV_FILE_PATH = "exemple.csv";


        String documentsPath = System.getProperty("user.home") + "/Documents";

        Path documentsDirectory = Paths.get(documentsPath);

        Path csvPath = documentsDirectory.resolve(SAMPLE_CSV_FILE_PATH);

        try {
            FileWriter writer = new FileWriter(fichierSortie);
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("Arrondissement", "Nombre d'interventions"));
            CSVParser csvParser = CSVParser.parse(csvPath, Charset.defaultCharset(), CSVFormat.DEFAULT.withHeader());

            try {
                for (CSVRecord csvRecord : csvParser) {
                    String arrondissement = csvRecord.get("Arrondissement");
                    String nbInterventions = csvRecord.get("Nombre d'interventions");

                    csvPrinter.printRecord(arrondissement + "," + nbInterventions);
                    csvPrinter.flush();


                }
            } catch (Exception IllegalArgumentException) {
                System.out.println("Il manque une ou plusieurs columns");
            }
        } catch(Exception NoSuchFIleException) {
            System.out.println("Le fichier n'existe pas");

        }
    }
}
