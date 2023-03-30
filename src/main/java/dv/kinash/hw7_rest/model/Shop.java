package dv.kinash.hw7_rest.model;

public class Shop {
    Integer id;
    String name;
    String city;
    String street;
    Integer headcount;
    Boolean hasWebsite;

    public Shop() {
    }

    public Shop(String name, String city, String street, Integer headcount, Boolean hasWebsite) {
        this.name = name;
        this.city = city;
        this.street = street;
        this.headcount = headcount;
        this.hasWebsite = hasWebsite;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getHeadcount() {
        return headcount;
    }

    public void setHeadcount(Integer headcount) {
        this.headcount = headcount;
    }

    public Boolean getHasWebsite() {
        return hasWebsite;
    }

    public void setHasWebsite(Boolean hasWebsite) {
        this.hasWebsite = hasWebsite;
    }
}
