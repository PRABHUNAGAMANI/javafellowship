package problemsinforloop;

import java.util.Scanner;

public class Sumofnaturalnumber
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("ENTER THE NUMBER");
        int input = scan.nextInt();
        int sum=0;

        for(int i=1;i<=input;i++)
        {
            sum=sum+i;
        }

        System.out.println(sum);
    }
}
