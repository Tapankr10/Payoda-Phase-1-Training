package com.blood.models;



import java.util.Date;

public class Donation {
    private String donationId;
    private String bloodType;
    private Date donationDate;

    // Constructors
    public Donation(String donationId, String bloodType, Date donationDate) {
        this.donationId = donationId;
        this.bloodType = bloodType;
        this.donationDate = donationDate;
    }

    // Getters and Setters
    public String getDonationId() { return donationId; }
    public void setDonationId(String donationId) { this.donationId = donationId; }

    public String getBloodType() { return bloodType; }
    public void setBloodType(String bloodType) { this.bloodType = bloodType; }

    public Date getDonationDate() { return donationDate; }
    public void setDonationDate(Date donationDate) { this.donationDate = donationDate; }
}

