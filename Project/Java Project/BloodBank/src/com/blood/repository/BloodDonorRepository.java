package com.blood.repository;


import com.blood.models.BloodDonor;

import java.util.ArrayList;
import java.util.List;

public class BloodDonorRepository {
    private static List<BloodDonor> bloodDonors = new ArrayList<>();

 

    public List<BloodDonor> getAllBloodDonors() {
        return new ArrayList<>(bloodDonors);
    }
}
