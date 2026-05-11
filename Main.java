package Entity;

public class Main {
    public static void main(String[] args) {

        Student s1 = new Student("Nishita", "22-46932-1@student.aiub.edu", "22-46932-1", "CSE");

        Faculty f1 = new Faculty("Rafi", "rafi@aiub.edu", "1101", "CSE");

        Slot slot1 = new Slot("1st", "Sunday", "10:00 AM");

        Consultation c1 = new OnlineConsultation();

        Booking b1 = new Booking("B101", s1, f1, slot1, c1);

        System.out.println("----- Booking Information -----");
        b1.showBooking();

        System.out.println();
        b1.confirmBooking();

        b1.insertInfo();

        b1.readInfo();

        Slot slot2 = new Slot("S102", "Monday", "11:00 AM");
        Consultation c2 = new OfflineConsultation();

        Booking b2 = new Booking("B101", s1, f1, slot2, c2);

        b2.updateInfo();

        b2.readInfo();

        b2.deleteInfo();

        b2.readInfo();
    }
}