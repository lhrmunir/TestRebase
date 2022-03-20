package com.examples.marshallingunmarshalling;

/*
    https://ibytecode.com/blog/jaxb-marshalling-and-unmarshalling-example/
    STEP 1B:


    https://stackoverflow.com/questions/52502189/java-11-package-javax-xml-bind-does-not-exist
    https://www.dariawan.com/tutorials/java/using-jaxb-java-11/
    https://www.vogella.com/tutorials/JAXB/article.html
 */
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "employee")
public class Employee {

    @XmlAttribute
    private int id;
    private String name;
    private String department;
    private Address address;

    //Must have no-argument constructor
    public Employee() { }

    public Employee(int id, String name, String department, Address address) {
        super();
        this.id = id;
        this.name = name;
        this.department = department;
        this.address = address;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", department="
                + department + ", address=" + address + "]";
    }
}
