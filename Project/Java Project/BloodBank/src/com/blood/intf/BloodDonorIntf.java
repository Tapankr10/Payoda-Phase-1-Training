package com.blood.intf;

import com.blood.models.BloodDonor;

import java.util.List;

public interface BloodDonorIntf {
    void addBloodDonor(BloodDonor bloodDonor);
    BloodDonor getBloodDonor(String donorId);
    void updateBloodDonor(BloodDonor bloodDonor);
    void deleteBloodDonor(String donorId);
    List<BloodDonor> getAllBloodDonors();
}