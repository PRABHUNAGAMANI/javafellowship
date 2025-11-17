package problemsinforloop;

import java.util.Scanner;

public class reversethenumber
{
    public static void main(String[] args)
    {
        Scanner scan =new Scanner(System.in);
        System.out.println("ENTER THE NUMBER");
        int input = scan.nextInt();
        int reversed=0;

        for(int i=input;i>0;i /= 10)
        {
            int remainder = i%10;
            reversed= reversed*10+remainder;
        }

        System.out.println(reversed);
    }
}
