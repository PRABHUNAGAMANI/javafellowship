package problemsinswitchcase;

import java.util.Scanner;

public class Checkvowels
{
    public void vowelornot()
    {
        Scanner scan=new Scanner(System.in);
        System.out.println("ENTER THE LETTER");
        char input=scan.next().charAt(0);

        switch (input)
        {
            case 'a':
                System.out.println("vowel");
            case 'e':
                System.out.println("vowel");
            case 'i':
                System.out.println("vowel");
            case 'o':
                System.out.println("vowel");
            case 'u':
                System.out.println("vowel");
            case 'A':
                System.out.println("vowel");
            case 'E':
                System.out.println("vowel");
            case 'I':
                System.out.println("vowel");
            case 'O':
                System.out.println("vowel");
            case 'U':
                System.out.println("vowel");
            default:
                System.out.println("consonant");
        }
    }

    public static void main(String[] args)
    {
        Checkvowels obj=new Checkvowels();
        obj.vowelornot();
    }
}
