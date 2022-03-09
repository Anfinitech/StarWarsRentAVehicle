package Model;

public class rentModel {

    private int rentID;
    private int clientID;
    private int plate;
    private String datetime;
    private String ocassion;
    private String timeLength;
    private double cost;

    public rentModel(int rentID, int clientID, int plate, String datetime, String ocassion, String timeLength, double cost) {
        this.rentID = rentID;
        this.clientID = clientID;
        this.plate = plate;
        this.datetime = datetime;
        this.ocassion = ocassion;
        this.timeLength = timeLength;
        this.cost = cost;
    }

    public int getRentID() {
        return rentID;
    }

    public int getClientID() {
        return clientID;
    }

    public int getPlate() {
        return plate;
    }

    public String getDatetime() {
        return datetime;
    }

    public String getOcassion() {
        return ocassion;
    }

    public String getTimeLength() {
        return timeLength;
    }

    public double getCost() {
        return cost;
    }

    public void setRentID(int rentID) {
        this.rentID = rentID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public void setPlate(int plate) {
        this.plate = plate;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public void setOcassion(String ocassion) {
        this.ocassion = ocassion;
    }

    public void setTimeLength(String timeLength) {
        this.timeLength = timeLength;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return String.format("%-4d \t %-4d \t %-4d \t %-20s \t %-20s \t %-10s \t $%,.2f", rentID, clientID, plate, datetime, ocassion, timeLength, cost);
    }

}
