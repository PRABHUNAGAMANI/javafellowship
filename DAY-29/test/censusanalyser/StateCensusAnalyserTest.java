package test.censusanalyser;


import censusanalyser.StateCensusAnalyser;
import exception.CensusAnalyserException;
import org.junit.Assert;
import org.junit.Test;

public class StateCensusAnalyserTest {

    private static final String STATE_CENSUS_CSV = "resources/StateCensusData.csv";

    private static final String STATE_CODE_CSV = "resources/IndiaStateCode.csv";

    @Test
    public void givenCorrectCensusCSV_ShouldReturnCount() throws Exception {
        StateCensusAnalyser analyser = new StateCensusAnalyser();
        int count = analyser.loadStateCensusData(STATE_CENSUS_CSV);
        Assert.assertEquals(28, count);
    }

    @Test
    public void givenWrongFile_ShouldThrowException() {
        StateCensusAnalyser analyser = new StateCensusAnalyser();
        try {
            analyser.loadStateCensusData("wrong.csv");
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(
                    CensusAnalyserException.ExceptionType.FILE_NOT_FOUND,
                    e.type
            );
        }
    }

    @Test
    public void givenWrongType_ShouldThrowException() {
        StateCensusAnalyser analyser = new StateCensusAnalyser();
        try {
            analyser.loadStateCensusData("resources/wrong_type.txt");
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(
                    CensusAnalyserException.ExceptionType.INVALID_TYPE,
                    e.type
            );
        }
    }

    @Test
    public void testLoadStateCensusData() {
        StateCensusAnalyser analyser = new StateCensusAnalyser();
        try {
            int count = analyser.loadStateCensusData("resources/StateCensusData.csv");
            System.out.println("Number of states in CSV: " + count);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }

}

