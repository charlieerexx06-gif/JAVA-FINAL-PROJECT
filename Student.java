package Entity;

public class Student extends Person {
    private String studentId;
    private String department;

    Student(String name, String email, String studentId, String department) {
        super(name, email);
        this.studentId = studentId;
        this.department = department;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    void showStudent() {
        showInfo();
        System.out.println("Student ID: " + studentId);
        System.out.println("Department: " + department);
    }
}