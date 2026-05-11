package Entity;

public abstract class Consultation {
    abstract void showConsultationType();

    abstract String getConsultationType();

    void info() {
        System.out.println("AIUB Faculty Consulting Slot Booking System");
    }
}