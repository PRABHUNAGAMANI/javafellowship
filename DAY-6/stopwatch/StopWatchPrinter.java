package stopwatch;

public class StopWatchPrinter
{
    public void printStartTime(long startTime)
    {
        System.out.println("START TIME : " + startTime / 1000.0 + "s");
    }

    public void printEndTime(long endTime)
    {
        System.out.println("END TIME : " + endTime / 1000.0 + "s");
    }

    public void printElapsedTime(double elapsed)
    {
        System.out.println("ELAPSED TIME IN SECONDS : " + elapsed + "s");
    }
}
