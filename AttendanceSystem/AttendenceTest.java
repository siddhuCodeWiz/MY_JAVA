package AttendanceSystem;

import java.util.ArrayList;

public class AttendenceTest {
    public static void main(String[] args) {
        Student s1 = new Student("Siddharth", 20, "male", "CSE");
        Student s2 = new Student("Pranav", 20, "male", "CSE");
        Student s3 = new Student("Abhinav", 20, "male", "CSE");
        Student s4 = new Student("Sairam", 20, "male", "CSE");
        
        Teacher t = new Teacher("Deepa", 40, "Female", "CSE");

        ArrayList<Student> students = new ArrayList<Student>();

        students.add(s1);students.add(s2);students.add(s3);students.add(s4);

        t.markAttendance(students);
    }
}
