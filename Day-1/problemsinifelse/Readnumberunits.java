package problemsinifelse;

import java.util.Scanner;

public class Readnumberunits
{
    public static void main(String[] args)
    {
        Scanner scan=new Scanner(System.in);
        System.out.println("ENTER THE NUMBER");
        Long inputnumber=scan.nextLong();


        if(inputnumber == 1)
        {
            System.out.println("ONE");
        }
        else if (inputnumber == 10)
        {
            System.out.println("TEN");
        }
        else if (inputnumber == 100)
        {
            System.out.println("HUNDRED");
        }
        else if (inputnumber == 1000)
        {
            System.out.println("THOUSAND");
        }
        else if (inputnumber == 10000)
        {
            System.out.println("TEN THOUSAND");
        }
        else
        {
            System.out.println("INVALID NUMBER");
        }

    }
}
