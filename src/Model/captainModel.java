
package Model;

public class captainModel {
    private int license;
    private String name;
    private String species;
    private int inChargeOf;

    public captainModel(int license, String name, String species, int inChargeOf) {
        this.license = license;
        this.name = name;
        this.species = species;
        this.inChargeOf = inChargeOf;
    }
    
    public captainModel(String name, String species, int inChargeOf) {
        this.name = name;
        this.species = species;
        this.inChargeOf = inChargeOf;
    }
    
    public captainModel(String name, String species) {
        this.name = name;
        this.species = species;
    }

    public int getLicense() {
        return license;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public int getInChargeOf() {
        return inChargeOf;
    }

    public void setLicense(int license) {
        this.license = license;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setInChargeOf(int inChargeOf) {
        this.inChargeOf = inChargeOf;
    }

    @Override
    public String toString() {
        return String.format("%-4d \t %-20s \t %-10s \t %d", license, name, species, inChargeOf);
    }
    
    
}
