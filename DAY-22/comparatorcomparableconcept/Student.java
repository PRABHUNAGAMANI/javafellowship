package comparatorcomparableconcept;

public class Student implements Comparable<Student>
{
    int studentId;
    String studentName;
    String studentSubject;

    public Student(int studentId, String studentName, String studentSubject)
    {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentSubject = studentSubject;
    }

    public int compareTo(Student s)
    {
        return this.studentId-s.studentId;
    }

    public String toString()
    {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentSubject='" + studentSubject + '\'' +
                '}';
    }
}
