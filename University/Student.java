package University;

public class Student extends Person {
    private int year;
    private String section;
    private double cgpa;
    private int[] noOfGrades;
    private double fees;

    {
        noOfGrades = new int[0];
    }

    Student(String name, int age, String gender, double weight, String nationality, int year, String section, int[] noOfGrades){
        super(name, age, gender, weight, nationality);
        this.year = year;
        this.section = section;
        this.noOfGrades = noOfGrades;
        this.fees = calculateFees();
        calcCgpa();
    }

    private double calculateFees(){
        switch (year) {
            case 1:
                return 20_000;
            
            case 2:
                return 30_000;
                
            case 3:
            return 40_000;

            case 4:
                return 50_000;
            
            default:
                return 0;
        }
    }

    private void calcCgpa(){
        int totalGrades = 0;
        int totalSubs = 0;

        for (int grade : noOfGrades) {
            totalGrades += grade;
            totalSubs+=1;
        }

        double updatedCgpa = ((double) totalGrades / (totalSubs * 10))*10;
        this.cgpa = updatedCgpa;
        // return updatedCgpa;
    }

    public boolean applyForPostGraduate() {
        if (year == 4 && cgpa > 8.0) {
            return true;
        }
        return false;
    }

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    public double getCgpa(){
        return cgpa;
    }

    @Override
    public void canVote(){
        super.canVote();
    }
}
