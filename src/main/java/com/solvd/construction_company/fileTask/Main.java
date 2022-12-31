package com.solvd.construction_company.fileTask;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Logger logger = LogManager.getLogger(Main.class);

        File sourceFile = new File("src/main/resources/fileTask/text.txt");
        File targetFile = new File("src/main/resources/fileTask/result.txt");

        //Way 1 with Utils
        try {
            Map<String, Integer> words = new HashMap<>();
            List<String> strings = Arrays.asList("Harry", "Ron", "Hermione");

            String text = FileUtils.readFileToString(sourceFile, Charset.defaultCharset());
            for (String s : strings) {
                words.put(s, StringUtils.countMatches(text, s));
            }
            FileUtils.writeLines(targetFile, words.entrySet());
            logger.info("Successfully wrote to the file.");
        } catch (IOException e) {
            logger.error("An error occurred.");
            e.printStackTrace();
        }


        //Way 2 with Java
        /*
        int harryCount = 0;
        int hermioneCount = 0;
        int ronCount = 0;
        Scanner scanner = new Scanner(sourceFile);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains("Harry")) {
                harryCount = harryCount + 1;
            }
            if (line.contains("Hermione")) {
                hermioneCount = hermioneCount + 1;
            }
            if (line.contains("Ron")) {
                ronCount = ronCount + 1;
            }
        }
        try {
            FileWriter myWriter = new FileWriter(targetFile);
            myWriter.write("Harry " + harryCount + System.lineSeparator());
            myWriter.write("Hermione " + hermioneCount + System.lineSeparator());
            myWriter.write("Ron " + ronCount + System.lineSeparator());
            myWriter.close();
            logger.info("Successfully wrote to the file.");
        } catch (IOException e) {
            logger.error("An error occurred.");
            e.printStackTrace();
        }*/
    }
}
