package Model;

public class transportVModel {

    private int plate;
    private int crewSize;
    private int passengersCapacity;

    public transportVModel(int plate, int crew, int passengers) {
        this.plate = plate;
        this.crewSize = crew;
        this.passengersCapacity = passengers;
    }

    public transportVModel(int crew, int passengers) {
        this.crewSize = crew;
        this.passengersCapacity = passengers;
    }

    public int getPlate() {
        return plate;
    }

    public int getCrewSize() {
        return crewSize;
    }

    public int getPassengersCapacity() {
        return passengersCapacity;
    }

    public void setPlate(int plate) {
        this.plate = plate;
    }

    public void setCrewSize(int crewSize) {
        this.crewSize = crewSize;
    }

    public void setPassengersCapacity(int passengersCapacity) {
        this.passengersCapacity = passengersCapacity;
    }

    @Override
    public String toString() {
        return String.format("%-4d \t %-5s \t %-7s ", plate, crewSize, passengersCapacity);
    }
}
