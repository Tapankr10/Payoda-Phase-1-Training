package com.blood.impl;


import com.blood.intf.DonorIntf;
import com.blood.models.Donor;

import java.util.ArrayList;
import java.util.List;

public class DonorImpl implements DonorIntf {
    private List<Donor> donors = new ArrayList<>();

    @Override
    public void addDonor(Donor donor) {
        donors.add(donor);
    }

    @Override
    public Donor getDonor(String donorId) {
        return donors.stream()
                .filter(d -> d.getDonorId().equals(donorId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void updateDonor(Donor donor) {
        Donor existingDonor = getDonor(donor.getDonorId());
        if (existingDonor != null) {
            existingDonor.setName(donor.getName());
            existingDonor.setBloodType(donor.getBloodType());
        }
    }

    @Override
    public void deleteDonor(String donorId) {
        donors.removeIf(d -> d.getDonorId().equals(donorId));
    }

    @Override
    public List<Donor> getAllDonors() {
        return new ArrayList<>(donors);
    }
}
