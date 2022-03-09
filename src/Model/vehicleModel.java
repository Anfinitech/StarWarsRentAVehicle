package Model;

public class vehicleModel {

    protected int plate;
    protected String name;
    protected double speed;
    protected double length;

    public vehicleModel(int plate, String name, double speed, double length) {
        this.plate = plate;
        this.name = name;
        this.speed = speed;
        this.length = length;
    }

    public vehicleModel(String name, double speed, double length) {
        this.name = name;
        this.speed = speed;
        this.length = length;
    }

    public int getPlate() {
        return plate;
    }

    public String getName() {
        return name;
    }

    public double getSpeed() {
        return speed;
    }

    public double getLength() {
        return length;
    }

    public void setPlate(int plate) {
        this.plate = plate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return String.format("%-4d \t %-20s \t %-10s \t %s", plate, name, speed, length);
    }

}
