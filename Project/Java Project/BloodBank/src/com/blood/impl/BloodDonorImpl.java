package com.blood.impl;


import com.blood.intf.BloodDonorIntf;
import com.blood.models.BloodDonor;

import java.util.ArrayList;
import java.util.List;

public class BloodDonorImpl implements BloodDonorIntf {
    private List<BloodDonor> bloodDonors = new ArrayList<>();

    @Override
    public void addBloodDonor(BloodDonor bloodDonor) {
        bloodDonors.add(bloodDonor);
    }

    @Override
    public BloodDonor getBloodDonor(String donorId) {
        return bloodDonors.stream()
                .filter(b -> b.getDonorId().equals(donorId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void updateBloodDonor(BloodDonor bloodDonor) {
        BloodDonor existingBloodDonor = getBloodDonor(bloodDonor.getDonorId());
        if (existingBloodDonor != null) {
            existingBloodDonor.setDonationId(bloodDonor.getDonationId());
        }
    }

    @Override
    public void deleteBloodDonor(String donorId) {
        bloodDonors.removeIf(b -> b.getDonorId().equals(donorId));
    }

    @Override
    public List<BloodDonor> getAllBloodDonors() {
        return new ArrayList<>(bloodDonors);
    }
}
