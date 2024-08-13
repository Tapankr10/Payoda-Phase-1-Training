package com.blood.intf;

import com.blood.models.Donation;

import java.util.List;

public interface DonationIntf {
    void addDonation(Donation donation);
    Donation getDonation(String donationId);
    void updateDonation(Donation donation);
    void deleteDonation(String donationId);
    List<Donation> getAllDonations();
}