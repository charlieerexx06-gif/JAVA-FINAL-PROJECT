package Entity;

public class Faculty extends Person {
    private String facultyId;
    private String department;

    Faculty(String name, String email, String facultyId, String department) {
        super(name, email);
        this.facultyId = facultyId;
        this.department = department;
    }

    public void setFacultyId(String facultyId) {
        this.facultyId = facultyId;
    }

    public String getFacultyId() {
        return facultyId;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    void showFaculty() {
        showInfo();
        System.out.println("Faculty ID: " + facultyId);
        System.out.println("Department: " + department);
    }
}