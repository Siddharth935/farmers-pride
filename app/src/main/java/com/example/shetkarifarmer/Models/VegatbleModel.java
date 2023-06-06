package com.example.shetkarifarmer.Models;

public class VegatbleModel {
    String CropName,Rate,farmerName,farmerMobileNumber,farmerMobileNumberTwo,farmerEmail,CropKG,City,CropImage;

    public VegatbleModel() {
    }

    public VegatbleModel(String cropName, String rate, String farmerName, String farmerMobileNumber, String farmerMobileNumberTwo, String farmerEmail, String cropKG, String city, String cropImage) {
        CropName = cropName;
        Rate = rate;
        this.farmerName = farmerName;
        this.farmerMobileNumber = farmerMobileNumber;
        this.farmerMobileNumberTwo = farmerMobileNumberTwo;
        this.farmerEmail = farmerEmail;
        CropKG = cropKG;
        City = city;
        CropImage = cropImage;
    }

    public String getCropName() {
        return CropName;
    }

    public void setCropName(String cropName) {
        CropName = cropName;
    }

    public String getRate() {
        return Rate;
    }

    public void setRate(String rate) {
        Rate = rate;
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

    public String getCropKG() {
        return CropKG;
    }

    public void setCropKG(String cropKG) {
        CropKG = cropKG;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getCropImage() {
        return CropImage;
    }

    public void setCropImage(String cropImage) {
        CropImage = cropImage;
    }
}
