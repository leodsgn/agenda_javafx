package org.addressbook.book;

import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;

public class Person implements Serializable {
    private final SimpleStringProperty name;
    private final SimpleStringProperty address;
    private final SimpleStringProperty address_2;
    private final SimpleStringProperty city;
    private final SimpleStringProperty state;
    private final SimpleStringProperty phone;

    public Person(String name, String address, String address_2, String city, String state, String phone) {
        this.name = new SimpleStringProperty(name);
        this.address = new SimpleStringProperty(address);
        this.address_2 = new SimpleStringProperty(address_2);
        this.city = new SimpleStringProperty(city);
        this.state = new SimpleStringProperty(state);
        this.phone = new SimpleStringProperty(phone);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getAddress() {
        return address.get();
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public String getAddress_2() {
        return address_2.get();
    }

    public void setAddress_2(String address_2) {
        this.address_2.set(address_2);
    }

    public String getCity() {
        return city.get();
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public String getState() {
        return state.get();
    }

    public void setState(String state) {
        this.state.set(state);
    }

    public String getPhone() {
        return phone.get();
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }
}
