package censusanalyser;

import com.opencsv.bean.CsvToBeanBuilder;
import exception.CensusAnalyserException;

import java.io.Reader;
import java.util.Iterator;

public class CSVBuilder<T> {

    public Iterator<T> getCSVIterator(Reader reader, Class<T> clazz)
            throws CensusAnalyserException {

        try {
            return new CsvToBeanBuilder<T>(reader)
                    .withType(clazz)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build()
                    .iterator();

        } catch (RuntimeException e) {
            throw new CensusAnalyserException(
                    e.getMessage(),
                    CensusAnalyserException.ExceptionType.INVALID_HEADER
            );
        }
    }
}

