package com.blood.models;


import java.util.Date;

public class BloodRequest {
    private String requestId;
    private String bloodType;
    private int quantity;
    private Date requestDate;

    // Constructors
    public BloodRequest(String requestId, String bloodType, int quantity, Date requestDate) {
        this.requestId = requestId;
        this.bloodType = bloodType;
        this.quantity = quantity;
        this.requestDate = requestDate;
    }

    // Getters and Setters
    public String getRequestId() { return requestId; }
    public void setRequestId(String requestId) { this.requestId = requestId; }

    public String getBloodType() { return bloodType; }
    public void setBloodType(String bloodType) { this.bloodType = bloodType; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public Date getRequestDate() { return requestDate; }
    public void setRequestDate(Date requestDate) { this.requestDate = requestDate; }
}
