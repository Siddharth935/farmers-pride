package com.example.shetkarifarmer.Models;

public class RegisterModel {
    String satBaraNo,farmerName, farmerMobileNumber ,farmerMobileNumberTwo ,farmerEmail ,state, country, addresss ,pincode, city,getUserImage;

    public RegisterModel() {
    }


    public RegisterModel(String satBaraNo, String farmerName, String farmerMobileNumber, String farmerMobileNumberTwo, String farmerEmail, String state, String country, String addresss, String pincode, String city, String getUserImage) {
        this.satBaraNo = satBaraNo;
        this.farmerName = farmerName;
        this.farmerMobileNumber = farmerMobileNumber;
        this.farmerMobileNumberTwo = farmerMobileNumberTwo;
        this.farmerEmail = farmerEmail;
        this.state = state;
        this.country = country;
        this.addresss = addresss;
        this.pincode = pincode;
        this.city = city;
        this.getUserImage = getUserImage;
    }


    public String getSatBaraNo() {
        return satBaraNo;
    }

    public void setSatBaraNo(String satBaraNo) {
        this.satBaraNo = satBaraNo;
    }

    public String getFarmerName() {
        return farmerName;
    }

    public void setFarmerName(String farmerName) {
        this.farmerName = farmerName;
    }

    public String getFarmerMobileNumber() {
        return farmerMobileNumber;
    }

    public void setFarmerMobileNumber(String farmerMobileNumber) {
        this.farmerMobileNumber = farmerMobileNumber;
    }

    public String getFarmerMobileNumberTwo() {
        return farmerMobileNumberTwo;
    }

    public void setFarmerMobileNumberTwo(String farmerMobileNumberTwo) {
        this.farmerMobileNumberTwo = farmerMobileNumberTwo;
    }

    public String getFarmerEmail() {
        return farmerEmail;
    }

    public void setFarmerEmail(String farmerEmail) {
        this.farmerEmail = farmerEmail;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddresss() {
        return addresss;
    }

    public void setAddresss(String addresss) {
        this.addresss = addresss;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getGetUserImage() {
        return getUserImage;
    }

    public void setGetUserImage(String getUserImage) {
        this.getUserImage = getUserImage;
    }
}
