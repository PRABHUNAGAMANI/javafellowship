package problemsinifelse;

import java.util.Scanner;

public class Readsinglenumber
{
    public static void main(String[] args)
    {
        Scanner scan=new Scanner(System.in);
        System.out.println("ENTER THE NUMBER");
        int inputnumber=scan.nextInt();


        if(inputnumber == 1)
        {
            System.out.println("ONE");
        }
        else if (inputnumber == 2)
        {
            System.out.println("TWO");
        }
        else if (inputnumber == 3)
        {
            System.out.println("THREE");
        }
        else if (inputnumber == 4)
        {
            System.out.println("FOUR");
        }
        else if (inputnumber == 5)
        {
            System.out.println("FIVE");
        }
        else if (inputnumber == 6)
        {
            System.out.println("SIX");
        }
        else if (inputnumber == 7)
        {
            System.out.println("SEVEN");
        }
        else if (inputnumber == 8)
        {
            System.out.println("EIGHT");
        }
        else if (inputnumber == 9)
        {
            System.out.println("NINE");
        }
        else
        {
            System.out.println("INVALID NUMBER");
        }
    }
}
