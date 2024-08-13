package com.blood.service;



import com.blood.impl.DonorImpl;
import com.blood.impl.BloodDonorImpl;
import com.blood.impl.DonationImpl;
import com.blood.impl.BloodRequestImpl;
import com.blood.intf.DonorIntf;
import com.blood.intf.BloodDonorIntf;
import com.blood.intf.DonationIntf;
import com.blood.intf.BloodRequestIntf;
import com.blood.models.Donor;
import com.blood.models.BloodDonor;
import com.blood.models.Donation;
import com.blood.models.BloodRequest;

import java.util.Date;
import java.util.List;

public class BloodBankService {
    private DonorIntf donorService;
    private BloodDonorIntf bloodDonorService;
    private DonationIntf donationService;
    private BloodRequestIntf bloodRequestService;

    // Constructor to initialize services
    public BloodBankService() {
        this.donorService = new DonorImpl();
        this.bloodDonorService = new BloodDonorImpl();
        this.donationService = new DonationImpl();
        this.bloodRequestService = new BloodRequestImpl();
    }

    // Donor Operations
    public void addDonor(Donor donor) {
        donorService.addDonor(donor);
    }

    public Donor getDonor(String donorId) {
        return donorService.getDonor(donorId);
    }

    public void updateDonor(Donor donor) {
        donorService.updateDonor(donor);
    }

    public void deleteDonor(String donorId) {
        donorService.deleteDonor(donorId);
    }

    public List<Donor> getAllDonors() {
        return donorService.getAllDonors();
    }

    // Blood Donor Operations
    public void addBloodDonor(BloodDonor bloodDonor) {
        bloodDonorService.addBloodDonor(bloodDonor);
    }

    public BloodDonor getBloodDonor(String donorId) {
        return bloodDonorService.getBloodDonor(donorId);
    }

    public void updateBloodDonor(BloodDonor bloodDonor) {
        bloodDonorService.updateBloodDonor(bloodDonor);
    }

    public void deleteBloodDonor(String donorId) {
        bloodDonorService.deleteBloodDonor(donorId);
    }

    public List<BloodDonor> getAllBloodDonors() {
        return bloodDonorService.getAllBloodDonors();
    }

    // Donation Operations
    public void addDonation(Donation donation) {
        donationService.addDonation(donation);
    }

    public Donation getDonation(String donationId) {
        return donationService.getDonation(donationId);
    }

    public void updateDonation(Donation donation) {
        donationService.updateDonation(donation);
    }

    public void deleteDonation(String donationId) {
        donationService.deleteDonation(donationId);
    }

    public List<Donation> getAllDonations() {
        return donationService.getAllDonations();
    }

    // Blood Request Operations
    public void addBloodRequest(BloodRequest request) {
        bloodRequestService.addRequest(request);
    }

    public BloodRequest getBloodRequest(String requestId) {
        return bloodRequestService.getRequest(requestId);
    }

    public void updateBloodRequest(BloodRequest request) {
        bloodRequestService.updateRequest(request);
    }

    public void deleteBloodRequest(String requestId) {
        bloodRequestService.deleteRequest(requestId);
    }

    public List<BloodRequest> getAllBloodRequests() {
        return bloodRequestService.getAllRequests();
    }
}
