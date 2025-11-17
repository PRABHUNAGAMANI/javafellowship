package problemsinwhileloop;

import java.util.Scanner;

public class Sumofnaturalnumber
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("ENTER THE NUMBER");
        int inputnumber=scan.nextInt();
        int sum=0;
        int intialnumber=1;

        while (intialnumber <= inputnumber)
        {
            sum = sum + intialnumber;
            intialnumber++;
        }

        System.out.println("SUM OF N NATURAL NUMBERS : "+sum);
    }
}
