package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Check {

    private static final String ONLY_NUMBERS_ARE_ALLOWED = "Only numbers are allowed. Please Enter the number of matches to calculate the Ranking table: ";

    /**
     * Validate only integers ar allowed
     *
     * @param in
     * @return
     */
    public static int readOnlyIntegers(Scanner in) {

        int integer = 0;
        try
        {
            integer = in.nextInt();
            if (integer == 0) {
                throw new Exception();
            }
        }
        catch(Exception e)
        {
            System.out.print(ONLY_NUMBERS_ARE_ALLOWED);
            in.nextLine();
            integer = readOnlyIntegers(in);
        }
        return integer;
    }

    /**
     * Method to read an agnostic file path.
     *
     * @param path
     */
    public static String[] readFromFile(Scanner path) {

        File tempFile = new File(path.nextLine());
        File agnosticFile = new File(path.nextLine().replace("//", "\\"));
        String[] array = new String[0];

        try {
            if (tempFile.exists()) {
                System.out.println("name fo the file" + tempFile.getPath());
                Path p = Paths.get(tempFile.getPath());
                List<String> lines = Files.readAllLines(p);
                array = lines.toArray(String[]::new);
            } else if (agnosticFile.exists()) {
                System.out.println("name fo the file" + tempFile.getPath());
                Path p = Paths.get(tempFile.getPath());
                List<String> lines = Files.readAllLines(p);
                array = lines.toArray(String[]::new);
            } else {
                System.out.print("File does not exist, please try again. ");
                array = readFromFile(path);
            }
        } catch (IOException e) {
            System.out.print("Sorry, there's an issue to read the path of the file, please try again. ");
            readFromFile(path);
        }

        return array;
    }
}
