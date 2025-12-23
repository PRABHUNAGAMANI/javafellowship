package comparatorcomparableconcept;

import java.util.ArrayList;
import java.util.Collections;

public class Main
{
    public static void main(String[] args)
    {
        ArrayList<Student> one=new ArrayList<>();
        one.add(new Student(3,"prabhu","java"));
        one.add(new Student(2,"vinoth","mern"));
        one.add(new Student(1,"anbu","python"));

//        Collections.sort(one);
//        System.out.println(one);

//        Collections.sort(one,new SortByName());
//        System.out.println(one);

        System.out.println(one);
    }
}
