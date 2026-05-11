package Entity;

public class Slot {
    private String slotNo;
    private String day;
    private String time;

    Slot(String slotNo, String day, String time) {
        this.slotNo = slotNo;
        this.day = day;
        this.time = time;
    }

    public void setSlotNo(String slotNo) {
        this.slotNo = slotNo;
    }

    public String getSlotNo() {
        return slotNo;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDay() {
        return day;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    void showSlot() {
        System.out.println("Slot No: " + slotNo);
        System.out.println("Day: " + day);
        System.out.println("Time: " + time);
    }
}