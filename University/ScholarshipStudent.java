package University;

class ScholarshipStudent extends Student {
    private boolean isEligible;

    public ScholarshipStudent(String name, int age, String gender, double weight, String nationality, int year, String section, int[] noOfGrades) {
        super(name, age, gender, weight, nationality, year, section, noOfGrades);
        this.isEligible = checkEligibilityForScholarship(super.getCgpa());
    }

    private boolean checkEligibilityForScholarship(double cgpa) {
        return cgpa > 9.0;
    }

    public void setEligible(boolean isEligible) {
        if (isEligible && checkEligibilityForScholarship(getCgpa())) {
            this.isEligible = true;
        } else {
            this.isEligible = false;
        }
    }

    public boolean isEligible() {
        return isEligible;
    }

}
/*Renewal of Scholarship: Implement a method to renew the scholarship annually based on certain criteria like maintaining a minimum GPA or fulfilling specific academic requirements.

Scholarship Benefits: Include methods to display the benefits of the scholarship, such as financial assistance, access to special programs, or academic resources.

Scholarship Application: Develop a method for scholarship students to apply for additional scholarships or grants within the university or externally.

Scholarship Termination: Implement a method to terminate the scholarship if the student fails to meet the renewal criteria or violates the terms and conditions of the scholarship. */
