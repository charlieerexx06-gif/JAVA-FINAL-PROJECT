package Entity;

public class OnlineConsultation extends Consultation {
    void showConsultationType() {
        System.out.println("Consultation Type: Online");
    }

    String getConsultationType() {
        return "Online";
    }
}