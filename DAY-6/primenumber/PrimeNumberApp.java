package primenumber;

import java.util.Scanner;

public class PrimeNumberApp
{
    public static void main(String[] args)
    {

        Scanner scan = new Scanner(System.in);
        System.out.println("ENTER THE NUMBER TO CHECK");
        int input = scan.nextInt();

        PrimeNumberService service = new PrimeNumberService();
        PrimeNumberPrinter printer = new PrimeNumberPrinter();

        boolean result = service.isPrime(input);
        printer.print(result);

        scan.close();
    }
}
