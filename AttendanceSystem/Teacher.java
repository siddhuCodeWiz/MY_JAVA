package AttendanceSystem;

import java.util.ArrayList;

public class Teacher {
    String name;
    int age;
    String gender;
    String dept;

    public Teacher(String name, int age, String gender, String dept){
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.dept = dept;
    }

    public void markAttendance(ArrayList<Student> s){
        for(Student i : s){
            i.attendance = true;
            System.out.println("Attendence marked for "+i.name);
        }
    }
}
