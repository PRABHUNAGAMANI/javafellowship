package censusanalyser;

public class CSVBuilderFactory {
    public static <T> CSVBuilder<T> createCSVBuilder() {
        return new CSVBuilder<>();
    }
}

