package Model;

public class vehicleRecordModel extends vehicleModel {

    private String type;
    private String subject;
    private String color;
    private String android;
    private int crewSize;
    private int passengersCapacity;

    public vehicleRecordModel(int plate, String name, double speed, double length, String type, String subject) {
        super(plate, name, speed, length);
        this.type = type;
        this.subject = subject;
    }

    public String getType() {
        return type;
    }

    public String getSubject() {
        return subject;
    }

    public String getColor() {
        return color;
    }

    public String getAndroid() {
        return android;
    }

    public int getCrewSize() {
        return crewSize;
    }

    public int getPassengersCapacity() {
        return passengersCapacity;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setAndroid(String android) {
        this.android = android;
    }

    public void setCrewSize(int crewSize) {
        this.crewSize = crewSize;
    }

    public void setPassengersCapacity(int passengersCapacity) {
        this.passengersCapacity = passengersCapacity;
    }

    @Override
    public String toString() {
        return String.format("%-4d \t %-25s %,7.2f \t %,10.2f \t %-10s \t %-20s", plate, name, speed, length, type, subject);
    }

}
