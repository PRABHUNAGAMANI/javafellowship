package problemsinforloop;

import java.util.Scanner;

public class Checkpalindrome
{

    public static void palindromeornot()
    {
        Scanner scan=new Scanner(System.in);
        System.out.println("ENTER THE NUMBER");
        int input=scan.nextInt();
        int reversed=0;

        for(int i=input;i>0;i/=10)
        {
            int remainder=i%10;
            reversed=reversed*10+remainder;
        }

        System.out.println("INPUT NUMBER : "+input);
        System.out.println("REVERSED NUMBER : "+reversed);
        if(input == reversed)
        {
            System.out.println("IT IS PALINDROME");
        }
        else
        {
            System.out.println("IT IS NOT PALINDROME");
        }
    }

    public static void main(String[] args)
    {
        Checkpalindrome.palindromeornot();
    }
}
