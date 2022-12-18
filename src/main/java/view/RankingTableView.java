package view;

import controller.TeamController;
import utils.Check;

import java.util.List;
import java.util.Scanner;

public class RankingTableView {

    private TeamController teamController;

    /**
     * Prepare the user interface of the program.
     */
    public void run() {

        //Create object of Scanner class so that we can take input from command line
        Scanner myScanner = new Scanner(System.in);
        int optionSelected, inputLine, idx;

        //Show prompt
        this.generalPrompt();

        optionSelected = Check.readOnlyIntegers(myScanner);

        switch (optionSelected) {
            case 1:
                myScanner.nextLine();
                System.out.print("Please enter the path of the file: ");
                String[] arrayMatches = Check.readFromFile(myScanner);

                //Print the final ranking table
                printFinalRankingTable(arrayMatches);
                break;

            case 2:

                System.out.print("Please Enter the number of matches to calculate the Ranking table: ");
                //Get the number of records that is going to input
                inputLine =  Check.readOnlyIntegers(myScanner);
                myScanner.nextLine();
                System.out.println("----------------------------------------");
                System.out.printf("Enter %d records with the final results for each match: (ex: lions 4, Snake 2)", inputLine);
                System.out.println("\n");

                //Copy each record into an Array
                String[] arrMatches = new String[inputLine];
                for (idx = 0; idx < inputLine; idx++) {
                    arrMatches[idx] = myScanner.nextLine();
                }

                //Print the final ranking table
                printFinalRankingTable(arrMatches);
                break;
        }

        this.run();
    }

    /**
     * Printing an init welcome message
     */
    public void generalPrompt() {

        System.out.println("\n\n");
        System.out.println("*************************************************");
        System.out.println("**  Welcome to the Ranking table for a league  **");
        System.out.println("*************************************************");
        System.out.println("\n");
        System.out.println("Please select an option: ");
        System.out.println("1.- Load the inputs from a file.");
        System.out.println("2.- Type the inputs.");
        System.out.print("\n");
        System.out.print("Option selected: ");

    }

    /**
     * Set the controller
     * @param controller
     */
    public void setController(TeamController controller) {
        this.teamController = controller;
    }

    /**
     * Display a success message
     *
     * @param message
     */
    public void successMessage(String message) {
        System.out.println(message);
    }

    /**
     * Printing the final ranking table
     * @param arrMatches
     */
    public void printFinalRankingTable(String[] arrMatches) {

        System.out.println("\n");
        System.out.println("************************************");
        System.out.println("**  Final Ranking table of teams  **");
        System.out.println("************************************");
        //Order the list by points
        List<String> sortedRankingFinalTable = teamController.calculateRankingTable(arrMatches);
        //Order the list alphabetically
        sortedRankingFinalTable.forEach(System.out::println);
    }
}
