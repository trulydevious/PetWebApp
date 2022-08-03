package database;
/**
 * Groomer class is used to define data from table groomers in database.
 */
public class Groomer {

    private int id;
    private String name;
    private String website;
    private String city;
    private String openDays;
    private String pets;

    /**
     * First constructor of Groomer class.
     */
    public Groomer(int id, String name, String website, String openDays, String city, String pets) {
        this.id = id;
        this.name = name;
        this.website = website;
        this.city = city;
        this.openDays = openDays;
        this.pets = pets;
    }

    /**
     * Second constructor of Groomer class.
     */
    public Groomer(String name, String website, String openDays, String city, String pets) {
        this.name = name;
        this.website = website;
        this.city = city;
        this.openDays = openDays;
        this.pets = pets;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return this.website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getOpenDays() {
        return openDays;
    }

    public void setOpenDays(String openDays) {
        this.openDays = openDays;
    }

    public String getPets() {
        return this.pets;
    }

    public void setPets(String pets) {
        this.pets = pets;
    }
}
