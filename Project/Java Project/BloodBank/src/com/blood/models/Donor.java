package com.blood.models;


public class Donor {
    private String donorId;
    private String name;
    private String bloodType;
	private String bloodUnits;

    public Donor(String donorId, String name, String bloodType, String bloodUnits ) {
        this.donorId = donorId;
        this.name = name;
        this.bloodType = bloodType;
        this.bloodUnits = bloodUnits;
    }

    public String getDonorId() {
        return donorId;
    }

    public void setDonorId(String donorId) {
        this.donorId = donorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }
    public void setBloodUnits(String bloodUnits) {
        this.bloodUnits = bloodUnits;
    }
    public String GetBloodunit()
    {
    	return bloodUnits;
    }
}
