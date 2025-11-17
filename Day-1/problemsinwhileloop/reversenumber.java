package problemsinwhileloop;

import java.util.Scanner;

public class reversenumber
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("ENTER THE NUMBER");
        int input=scan.nextInt();
        int reversenumber=0;


        while (input != 0)
        {
           int remainder=input%10;
            reversenumber=reversenumber*10+remainder;
            input=input/10;
        }

        System.out.println(reversenumber);



    }
}
