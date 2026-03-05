package com.example.listycity;

import java.util.Objects;

/**
 * This is a class that defines a City.
 */
public class City implements Comparable<City> {
    /**
     * The name of the city.
     */
    private String city;
    /**
     * The name of the province.
     */
    private String province;

    /**
     * Constructor for City.
     * @param city The name of the city.
     * @param province The name of the province.
     */
    public City(String city, String province) {
        this.city = city;
        this.province = province;
    }

    /**
     * Gets the city name.
     * @return The city name.
     */
    public String getCityName() {
        return this.city;
    }

    /**
     * Gets the province name.
     * @return The province name.
     */
    public String getProvinceName() {
        return this.province;
    }

    /**
     * Compares this city to another city based on their names.
     * @param o The city to be compared.
     * @return A negative integer, zero, or a positive integer as this city's name
     * is lexicographically less than, equal to, or greater than the specified city's name.
     */
    @Override
    public int compareTo(City o) {
        return this.city.compareTo(o.getCityName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city1 = (City) o;
        return Objects.equals(city, city1.city) &&
                Objects.equals(province, city1.province);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, province);
    }
}
