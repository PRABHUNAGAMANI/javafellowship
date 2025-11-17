public class FirstProgram
{
    int numberone=10;
    static int numbertwo=100;
    public static void main(String[] args)
    {

        FirstProgram object=new FirstProgram();
        System.out.println("INSTANCE VARIABLE : "+object.numberone);
        System.out.println("STATIC VARIABLE : "+FirstProgram.numbertwo);
    }
}
