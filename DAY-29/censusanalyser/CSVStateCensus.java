package censusanalyser;

import com.opencsv.bean.CsvBindByName;

public class CSVStateCensus
{

    @CsvBindByName(column = "State")
    public String state;

    @CsvBindByName(column = "Population")
    public int population;

    @CsvBindByName(column = "AreaInSqKm")
    public int area;

    @CsvBindByName(column = "DensityPerSqKm")
    public int density;
}
