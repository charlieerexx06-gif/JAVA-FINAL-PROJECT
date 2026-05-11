package Entity;

import java.io.*;
import javax.swing.*;

public class Booking {
    private String bookingId;
    private Student student;
    private Faculty faculty;
    private Slot slot;
    private Consultation consultation;

    private File file;
    private FileWriter fwriter;

    public Booking() { }

    public Booking(String bookingId, Student student, Faculty faculty, Slot slot, Consultation consultation) {
        this.bookingId = bookingId;
        this.student = student;
        this.faculty = faculty;
        this.slot = slot;
        this.consultation = consultation;
    }

    public void confirmBooking() {
        System.out.println("Booking Confirmed Successfully");
    }

    public void showBooking() {
        System.out.println("Booking ID: " + bookingId);

        System.out.println("\nStudent Information:");
        student.showStudent();

        System.out.println("\nFaculty Information:");
        faculty.showFaculty();

        System.out.println("\nSlot Information:");
        slot.showSlot();

        System.out.println();
        consultation.showConsultationType();
    }

    // Create
    public void insertInfo() {
        try {
            file = new File("./Data/bookingdata.txt");

            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }

            fwriter = new FileWriter(file, true);

            fwriter.write("Booking ID: " + bookingId + "\n");
			fwriter.write("Student Name: " + student.name + "\n");
			fwriter.write("Student ID: " + student.getStudentId() + "\n");
			fwriter.write("Course: " + slot.getSlotNo() + "\n");
			fwriter.write("Faculty Name: " + faculty.name + "\n");
			fwriter.write("Faculty ID: " + faculty.getFacultyId() + "\n");
			fwriter.write("Date: " + slot.getDay() + "\n");
			fwriter.write("Time: " + slot.getTime() + "\n");
			fwriter.write("Consultation Type: " + consultation.getConsultationType() + "\n");
			fwriter.write("------------------------------" + "\n");

            fwriter.flush();
            fwriter.close();

            System.out.println("Booking Inserted Successfully.");
        }
        catch(IOException e) {
            JOptionPane.showMessageDialog(null, "File writing error.");
        }
    }

    // Read
    public void readInfo() {
        try {
            file = new File("./Data/bookingdata.txt");

            if (!file.exists()) {
                System.out.println("No Booking Found.");
                return;
            }

            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line;

            while((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();
            fr.close();
        }
        catch(IOException e) {
            JOptionPane.showMessageDialog(null, "File reading error.");
        }
    }

    // Update
    public void updateInfo() {
        try {
            file = new File("./Data/bookingdata.txt");

            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }

            fwriter = new FileWriter(file, false);

            fwriter.write("Booking ID: " + bookingId + "\n");
            fwriter.write("Student Name: " + student.name + "\n");
            fwriter.write("Student ID: " + student.getStudentId() + "\n");
            fwriter.write("Faculty Name: " + faculty.name + "\n");
            fwriter.write("Faculty ID: " + faculty.getFacultyId() + "\n");
            fwriter.write("Slot No: " + slot.getSlotNo() + "\n");
            fwriter.write("Day: " + slot.getDay() + "\n");
            fwriter.write("Time: " + slot.getTime() + "\n");
            fwriter.write("Consultation Type: " + consultation.getConsultationType() + "\n");
            fwriter.write("------------------------------" + "\n");

            fwriter.flush();
            fwriter.close();

            System.out.println("Booking Updated Successfully.");
        }
        catch(IOException e) {
            JOptionPane.showMessageDialog(null, "File updating error.");
        }
    }

    // Delete
    public void deleteInfo() {
        try {
            file = new File("./Data/bookingdata.txt");

            if (!file.exists()) {
                System.out.println("No Booking Found.");
                return;
            }

            fwriter = new FileWriter(file, false);
            fwriter.write("");
            fwriter.flush();
            fwriter.close();

            System.out.println("Booking Deleted Successfully.");
        }
        catch(IOException e) {
            JOptionPane.showMessageDialog(null, "File deleting error.");
        }
    }
}