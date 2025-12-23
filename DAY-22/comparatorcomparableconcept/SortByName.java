package comparatorcomparableconcept;

import java.util.Comparator;

public class SortByName implements Comparator<Student>
{

    @Override
    public int compare(Student o1, Student o2)
    {
        return o2.studentName.compareTo(o1.studentName);
    }
}
