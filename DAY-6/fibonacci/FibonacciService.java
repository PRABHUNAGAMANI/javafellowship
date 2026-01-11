package fibonacci;

public class FibonacciService
{
    public int[] generateSeries(int first, int second, int count)
    {
        int[] series = new int[count];

        for (int i = 0; i < count; i++)
        {
            series[i] = first;
            int third = first + second;
            first = second;
            second = third;
        }
        return series;
    }
}
