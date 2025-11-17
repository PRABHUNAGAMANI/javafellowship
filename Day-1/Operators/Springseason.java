package Operators;

import java.util.Scanner;

public class Springseason
{
    public static void main(String[] args)
    {
        Scanner scan =new Scanner(System.in);
        System.out.println("ENTER THE MONTH");
        int month=scan.nextInt();
        System.out.println("ENTER THE DATE");
        int date = scan.nextInt();

        boolean springseason=false;

        if((month == 3 && date>=20) ||
                (month == 4 && date<=30)||
                (month == 5 && date <=31)||
                (month == 6 && date <=20))
        {
            springseason=true;
        }
        else
        {
            springseason=false;
        }

        System.out.println(springseason);
    }
}
