package com.blood.models;


public class BloodDonor {
    private String donorId;
    private String donationId;

    // Constructors
    public BloodDonor(String donorId, String donationId) {
        this.donorId = donorId;
        this.donationId = donationId;
    }

    // Getters and Setters
    public String getDonorId() { return donorId; }
    public void setDonorId(String donorId) { this.donorId = donorId; }

    public String getDonationId() { return donationId; }
    public void setDonationId(String donationId) { this.donationId = donationId; }
}