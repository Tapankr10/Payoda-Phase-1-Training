package com.blood.intf;

import com.blood.models.Donor;

import java.util.List;

public interface DonorIntf {
    void addDonor(Donor donor);
    Donor getDonor(String donorId);
    void updateDonor(Donor donor);
    void deleteDonor(String donorId);
    List<Donor> getAllDonors();
}