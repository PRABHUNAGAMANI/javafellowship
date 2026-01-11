package stopwatch;

public class StopWatchService
{
    public long start()
    {
        return System.currentTimeMillis();
    }

    public long stop()
    {
        return System.currentTimeMillis();
    }

    public double elapsedSeconds(long startTime, long endTime)
    {
        return (endTime - startTime) / 1000.0;
    }
}
