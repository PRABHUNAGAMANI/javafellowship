package fibonacci;

import java.util.Scanner;

public class FibonacciApp
{
    public static void main(String[] args)
    {

        Scanner scan = new Scanner(System.in);

        System.out.println("ENTER THE FIRST NUMBER");
        int first = scan.nextInt();

        System.out.println("ENTER THE SECOND NUMBER");
        int second = scan.nextInt();

        System.out.println("ENTER THE NUMBER YOU WANT TO COUNT");
        int count = scan.nextInt();

        FibonacciService service = new FibonacciService();
        FibonacciPrinter printer = new FibonacciPrinter();

        int[] series = service.generateSeries(first, second, count);
        printer.print(series);

        scan.close();
    }
}
