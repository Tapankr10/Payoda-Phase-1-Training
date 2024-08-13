package com.blood.impl;

import com.blood.intf.DonationIntf;
import com.blood.models.Donation;

import java.util.ArrayList;
import java.util.List;

public class DonationImpl implements DonationIntf {
    private List<Donation> donations = new ArrayList<>();

    @Override
    public void addDonation(Donation donation) {
        donations.add(donation);
    }

    @Override
    public Donation getDonation(String donationId) {
        return donations.stream()
                .filter(d -> d.getDonationId().equals(donationId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void updateDonation(Donation donation) {
        Donation existingDonation = getDonation(donation.getDonationId());
        if (existingDonation != null) {
            existingDonation.setBloodType(donation.getBloodType());
            existingDonation.setDonationDate(donation.getDonationDate());
        }
    }

    @Override
    public void deleteDonation(String donationId) {
        donations.removeIf(d -> d.getDonationId().equals(donationId));
    }

    @Override
    public List<Donation> getAllDonations() {
        return new ArrayList<>(donations);
    }
}
