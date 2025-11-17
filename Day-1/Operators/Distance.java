package Operators;

import java.util.Scanner;

public class Distance
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("ENTER THE VALUE OF X1");
        int x1=scan.nextInt();
        System.out.println("ENTER THE VALUE OF X2");
        int x2=scan.nextInt();
        System.out.println("ENTER THE VALUE OF Y1");
        int y1=scan.nextInt();
        System.out.println("ENTER THE VALUE OF Y2");
        int y2=scan.nextInt();

        double distance=Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));

        System.out.println(distance);

    }
}
