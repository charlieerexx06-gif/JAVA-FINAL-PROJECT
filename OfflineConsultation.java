package Entity;

public class OfflineConsultation extends Consultation {
    public void showConsultationType() {
        System.out.println("Consultation Type: Offline");
    }

    public String getConsultationType() {
        return "Offline";
    }
}