package censusanalyser;

import com.opencsv.bean.CsvBindByName;

public class CSVStateCode
{

    @CsvBindByName(column = "StateName")
    public String stateName;

    @CsvBindByName(column = "StateCode")
    public String stateCode;
}

