package University;

class University {
    public static void main(String[] args) {
        int[] studentGrades = {8, 9, 7};
        Student student = new Student("Siddharth", 20, "Male", 76, "Indian", 2, "CSE", studentGrades);
        // student.getCgpa()
        System.out.println("Student: " + student.getName());
        System.out.println("CGPA: " + student.getCgpa());
        student.canTalk();
        student.canWalk();
        student.canVote();
        System.out.println();

        int[] undergradGrades = {9, 10, 9};
        ScholarshipStudent undergradStudent = new ScholarshipStudent("Pranav", 20, "Male", 55, "Indian", 2, "CSE", undergradGrades);
        System.out.println("Undergraduate Student: " + undergradStudent.getName());
        System.out.println("CGPA: " + undergradStudent.getCgpa());
        undergradStudent.canTalk();
        undergradStudent.canWalk();
        undergradStudent.canVote();
        System.out.println("Eligible for scholarship: " + undergradStudent.isEligible());
        System.out.println();

        undergradStudent.setEligible(false);
        System.out.println("Updated Eligibility for Scholarship: " + undergradStudent.isEligible());
    }
}
