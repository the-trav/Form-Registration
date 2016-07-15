package com.appspot.engineerassessment.business;

import java.io.Serializable;

/**
 *
 * @author trav
 * user POJO that will be added into database
 * 
 */
public class User implements Serializable {
    private String firstName, lastName, address, addressOptional, city, state, zip,joinDate;
    private final String COUNTRY = "US";
    public User(){
        firstName ="";
        lastName="";
        address="";
        addressOptional="";
        city="";
        state="";
        zip="";
    }

    private String makeFirstLetterCaps(String stringToCap){
        String newString="";
        if(stringToCap.length()>=1){
            newString = stringToCap.substring(0, 1).toUpperCase()+stringToCap.substring(1);
        }
        return newString;
    }
    
    public void setJoinDate(String joinDate){
        this.joinDate=joinDate;
    }
    
    public String getJoinDate(){
        return joinDate;
    }
    
    public String getCountry(){
        return COUNTRY;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = makeFirstLetterCaps(firstName);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = makeFirstLetterCaps(lastName);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressOptional() {
        return addressOptional;
    }

    public void setAddressOptional(String addressOptional) {
        this.addressOptional = addressOptional;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = makeFirstLetterCaps(city);
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
    
    @Override
    public String toString(){
        return String.format("%s %s %s %s %s %s %s %s",getFirstName(),getLastName(),getAddress(),getAddressOptional(),getCity(),getState(),getZip(),getCountry());
    }
}
