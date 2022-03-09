package Model;

public class clientModel {

    private int clientID;
    private String name;
    private String species;
    private String gender;

    public clientModel(int cliente_id, String name, String species, String gender) {
        this.clientID = cliente_id;
        this.name = name;
        this.species = species;
        this.gender = gender;
    }

    public int getClientID() {
        return clientID;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public String getGender() {
        return gender;
    }

    public void setCliente_id(int cliente_id) {
        this.clientID = cliente_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return String.format("%-4d \t %-20s \t %-10s \t %s", clientID, name, species, gender);
    }
}
