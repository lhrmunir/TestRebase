package com.examples.marshallingunmarshalling;

/*
    https://ibytecode.com/blog/jaxb-marshalling-and-unmarshalling-example/
    STEP 1A:


    https://stackoverflow.com/questions/52502189/java-11-package-javax-xml-bind-does-not-exist
    https://www.dariawan.com/tutorials/java/using-jaxb-java-11/
    https://www.vogella.com/tutorials/JAXB/article.html
 */
// package com.theopentutorials.jaxb.to;

import javax.xml.bind.annotation.XmlType;

@XmlType
public class Address {
    private String street;
    private String city;
    private String state;
    private long zip;
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public long getZip() {
        return zip;
    }
    public void setZip(long zip) {
        this.zip = zip;
    }
    @Override
    public String toString() {
        return "Address [street=" + street + ", city=" + city + ", state="
                + state + ", zip=" + zip + "]";
    }
}

