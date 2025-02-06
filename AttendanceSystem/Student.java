package AttendanceSystem;

public class Student {
    String name;
    int age;
    String gender;
    String dept;
    boolean attendance;

    public Student(String name, int age, String gender, String dept){
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.dept = dept;
        attendance = false;
    }

    
}
