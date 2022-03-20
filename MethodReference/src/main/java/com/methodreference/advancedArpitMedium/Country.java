package com.methodreference.advancedArpitMedium;

public class Country {
    String name;
    long population;

    Country(String name)
    {
        this.name=name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getPopulation() {
        return population;
    }
    public void setPopulation(long population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "[ name = "+name+" population = "+population+" ]";
    }
}
