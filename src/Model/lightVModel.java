package Model;

public class lightVModel {

    private int plate;
    private String color;
    private String android;

    public lightVModel(int plate, String color, String android) {
        this.plate = plate;
        this.color = color;
        this.android = android;
    }

    public lightVModel(String color, String android) {
        this.color = color;
        this.android = android;
    }

    public int getPlate() {
        return plate;
    }

    public String getColor() {
        return color;
    }

    public String getAndroid() {
        return android;
    }

    public void setPlate(int plate) {
        this.plate = plate;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setAndroid(String android) {
        this.android = android;
    }

    @Override
    public String toString() {
        return String.format("%-4d \t %-10s \t %-10s", plate, color, android);
    }

}
