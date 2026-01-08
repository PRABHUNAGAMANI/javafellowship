package censusanalyser;

import exception.CensusAnalyserException;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Iterator;

public class StateCensusAnalyser {

    // ================== Load Census Data and Return Total Count ==================
    public int loadStateCensusData(String csvFilePath) throws CensusAnalyserException {

        if (!csvFilePath.endsWith(".csv")) {
            throw new CensusAnalyserException(
                    "Invalid file type",
                    CensusAnalyserException.ExceptionType.INVALID_TYPE
            );
        }

        try {
            // Load file from resources folder
            InputStream inputStream = StateCensusAnalyser.class
                    .getClassLoader()
                    .getResourceAsStream(csvFilePath);

            if (inputStream == null) {
                throw new CensusAnalyserException(
                        "File not found",
                        CensusAnalyserException.ExceptionType.FILE_NOT_FOUND
                );
            }

            Reader reader = new InputStreamReader(inputStream);

            // Create CSVBuilder
            CSVBuilder<CSVStateCensus> builder = CSVBuilderFactory.createCSVBuilder();

            // Get iterator for CSVStateCensus class
            Iterator<CSVStateCensus> iterator = builder.getCSVIterator(reader, CSVStateCensus.class);

            int count = 0;
            while (iterator.hasNext()) {
                iterator.next();
                count++;
            }

            return count;

        } catch (CensusAnalyserException e) {
            throw e;
        } catch (Exception e) {
            throw new CensusAnalyserException(
                    e.getMessage(),
                    CensusAnalyserException.ExceptionType.FILE_NOT_FOUND
            );
        }
    }

    // ================== Display All State Census Data to Console ==================
    public void displayAllStateCensusData(String csvFilePath) throws CensusAnalyserException {

        if (!csvFilePath.endsWith(".csv")) {
            throw new CensusAnalyserException(
                    "Invalid file type",
                    CensusAnalyserException.ExceptionType.INVALID_TYPE
            );
        }

        try {
            // Load file from resources folder
            InputStream inputStream = StateCensusAnalyser.class
                    .getClassLoader()
                    .getResourceAsStream(csvFilePath);

            if (inputStream == null) {
                throw new CensusAnalyserException(
                        "File not found",
                        CensusAnalyserException.ExceptionType.FILE_NOT_FOUND
                );
            }

            Reader reader = new InputStreamReader(inputStream);

            // Create CSVBuilder
            CSVBuilder<CSVStateCensus> builder = CSVBuilderFactory.createCSVBuilder();

            // Get iterator
            Iterator<CSVStateCensus> iterator = builder.getCSVIterator(reader, CSVStateCensus.class);

            System.out.println("State Census Data:");
            System.out.println("State\tPopulation\tArea\tDensity");

            while (iterator.hasNext()) {
                CSVStateCensus state = iterator.next();
                System.out.println(state.state + "\t" +
                        state.population + "\t" +
                        state.area + "\t" +
                        state.density);
            }

        } catch (CensusAnalyserException e) {
            throw e;
        } catch (Exception e) {
            throw new CensusAnalyserException(
                    e.getMessage(),
                    CensusAnalyserException.ExceptionType.FILE_NOT_FOUND
            );
        }
    }

    // New method to search a state by name
    public CSVStateCensus searchStateCensus(String csvFilePath, String stateName)
            throws CensusAnalyserException {

        if (!csvFilePath.endsWith(".csv")) {
            throw new CensusAnalyserException(
                    "Invalid file type",
                    CensusAnalyserException.ExceptionType.INVALID_TYPE
            );
        }

        try {
            InputStream inputStream = StateCensusAnalyser.class
                    .getClassLoader()
                    .getResourceAsStream(csvFilePath);

            if (inputStream == null) {
                throw new CensusAnalyserException(
                        "File not found",
                        CensusAnalyserException.ExceptionType.FILE_NOT_FOUND
                );
            }

            Reader reader = new InputStreamReader(inputStream);
            CSVBuilder<CSVStateCensus> builder = CSVBuilderFactory.createCSVBuilder();
            Iterator<CSVStateCensus> iterator = builder.getCSVIterator(reader, CSVStateCensus.class);

            while (iterator.hasNext()) {
                CSVStateCensus state = iterator.next();
                if (state.state.equalsIgnoreCase(stateName)) {
                    return state; // Return the found state
                }
            }

            throw new CensusAnalyserException(
                    "State not found: " + stateName,
                    CensusAnalyserException.ExceptionType.STATE_NOT_FOUND
            );

        } catch (CensusAnalyserException e) {
            throw e;
        } catch (Exception e) {
            throw new CensusAnalyserException(
                    e.getMessage(),
                    CensusAnalyserException.ExceptionType.FILE_NOT_FOUND
            );
        }
    }


    // Method to get State Code by State Name
    public String getStateCode(String csvFilePath, String stateName) throws CensusAnalyserException {
        if (!csvFilePath.endsWith(".csv")) {
            throw new CensusAnalyserException(
                    "Invalid file type",
                    CensusAnalyserException.ExceptionType.INVALID_TYPE
            );
        }

        try {
            InputStream inputStream = StateCensusAnalyser.class
                    .getClassLoader()
                    .getResourceAsStream(csvFilePath);

            if (inputStream == null) {
                throw new CensusAnalyserException(
                        "File not found",
                        CensusAnalyserException.ExceptionType.FILE_NOT_FOUND
                );
            }

            Reader reader = new InputStreamReader(inputStream);
            CSVBuilder<CSVStateCode> builder = CSVBuilderFactory.createCSVBuilder();
            Iterator<CSVStateCode> iterator = builder.getCSVIterator(reader, CSVStateCode.class);

            while (iterator.hasNext()) {
                CSVStateCode state = iterator.next();
                if (state.stateName.equalsIgnoreCase(stateName)) {
                    return state.stateCode;
                }
            }

            throw new CensusAnalyserException(
                    "State not found",
                    CensusAnalyserException.ExceptionType.NO_SUCH_STATE
            );

        } catch (CensusAnalyserException e) {
            throw e;
        } catch (Exception e) {
            throw new CensusAnalyserException(
                    e.getMessage(),
                    CensusAnalyserException.ExceptionType.FILE_NOT_FOUND
            );
        }
    }
}

