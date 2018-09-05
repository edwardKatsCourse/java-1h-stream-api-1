package com.company.stream.realestate;

import java.util.Objects;


//POJO (Plain Old Java Object), model, dto
public class RealEstate {

    private Integer id;
    private String city;
    private String street;
    private Integer houseNumber;
    private Integer price;

    //constructors
    //getters/setters
    //toString
    //equals and hash code


    public RealEstate(Integer id, String city, String street, Integer houseNumber, Integer price) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.price = price;
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

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RealEstate that = (RealEstate) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(city, that.city) &&
                Objects.equals(street, that.street) &&
                Objects.equals(houseNumber, that.houseNumber) &&
                Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, houseNumber, price);
    }

    @Override
    public String toString() {
        return String.format(
                "%s;%s;%s;%s;%s",
                this.id,
                this.city,
                this.street,
                this.houseNumber,
                this.price
        );
    }
}
