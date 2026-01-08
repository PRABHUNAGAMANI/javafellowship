package censusanalyser;

import exception.CensusAnalyserException;
import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        StateCensusAnalyser analyser = new StateCensusAnalyser();
//        String csvFile = "resources/StateCensusData.csv";
//        Scanner sc = new Scanner(System.in);
//
//        try {
//            int count = analyser.loadStateCensusData(csvFile);
//            System.out.println("Number of states in CSV: " + count);
//
//            boolean exit = false;
//            while (!exit) {
//                System.out.println("\nSelect an option:");
//                System.out.println("1. Display all state census data");
//                System.out.println("2. Search for a state by name");
//                System.out.println("3. Exit");
//                System.out.print("Enter your choice (1-3): ");
//
//                int choice = sc.nextInt();
//                sc.nextLine(); // consume newline
//
//                switch (choice) {
//                    case 1:
//                        System.out.println("\nDisplaying all state census data:");
//                        analyser.displayAllStateCensusData(csvFile);
//                        break;
//                    case 2:
//                        System.out.print("Enter state name to search: ");
//                        String stateName = sc.nextLine();
//                        try {
//                            CSVStateCensus state = analyser.searchStateCensus(csvFile, stateName);
//                            System.out.println("Census Info for " + state.state + ":");
//                            System.out.println("-----------------------------------------");
//                            System.out.println("Population: " + state.population);
//                            System.out.println("Area: " + state.area + " sq km");
//                            System.out.println("Density: " + state.density + " per sq km");
//                        } catch (CensusAnalyserException e) {
//                            System.err.println("Error: " + e.getMessage());
//                            System.err.println("Exception Type: " + e.type);
//                        }
//                        break;
//                    case 3:
//                        System.out.println("Exiting program...");
//                        exit = true;
//                        break;
//                    default:
//                        System.out.println("Invalid choice! Please select 1-3.");
//                        break;
//                }
//            }
//
//        } catch (CensusAnalyserException e) {
//            System.err.println("Error: " + e.getMessage());
//            System.err.println("Exception Type: " + e.type);
//        }
//    }
//}

import exception.CensusAnalyserException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StateCensusAnalyser analyser = new StateCensusAnalyser();
        String censusCSV = "resources/StateCensusData.csv";
        String stateCodeCSV = "resources/IndiaStateCode.csv";
        Scanner sc = new Scanner(System.in);

        try {
            int count = analyser.loadStateCensusData(censusCSV);
            System.out.println("Number of states in CSV: " + count);

            boolean exit = false;
            while (!exit) {
                System.out.println("\nSelect an option:");
                System.out.println("1. Display all state census data");
                System.out.println("2. Search for a state by name");
                System.out.println("3. Get state code by state name");
                System.out.println("4. Exit");
                System.out.print("Enter your choice (1-4): ");

                int choice = sc.nextInt();
                sc.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        System.out.println("\nDisplaying all state census data:");
                        analyser.displayAllStateCensusData(censusCSV);
                        break;

                    case 2:
                        System.out.print("Enter state name to search: ");
                        String stateNameSearch = sc.nextLine();
                        try {
                            CSVStateCensus state = analyser.searchStateCensus(censusCSV, stateNameSearch);
                            System.out.println("\nCensus Info for " + state.state + ":");
                            System.out.println("-----------------------------------------");
                            System.out.println("Population: " + state.population);
                            System.out.println("Area: " + state.area + " sq km");
                            System.out.println("Density: " + state.density + " per sq km");
                        } catch (CensusAnalyserException e) {
                            System.err.println("Error: " + e.getMessage());
                            System.err.println("Exception Type: " + e.type);
                        }
                        break;

                    case 3:
                        System.out.println("Enter state name to get code: ");
                        System.out.println("CODE OF THE STATE");
                        System.out.println("---------------------");
                        String stateNameCode = sc.nextLine();
                        try {
                            String stateCode = analyser.getStateCode(stateCodeCSV, stateNameCode);
                            System.out.println("State Code for " + stateNameCode + ": " + stateCode);
                        } catch (CensusAnalyserException e) {
                            System.err.println("Error: " + e.getMessage());
                            System.err.println("Exception Type: " + e.type);
                        }
                        break;

                    case 4:
                        System.out.println("Exiting program...");
                        System.out.println("------------------------");
                        exit = true;
                        break;

                    default:
                        System.out.println("Invalid choice! Please select 1-4.");
                        break;
                }
            }

        } catch (CensusAnalyserException e) {
            System.err.println("Error: " + e.getMessage());
            System.err.println("Exception Type: " + e.type);
        }
    }
}



