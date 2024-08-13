package com.blood.repository;


import com.blood.models.Donor;

import java.util.ArrayList;
import java.util.List;

public class DonorRepository {
    private static List<Donor> donors = new ArrayList<>();

   

    public List<Donor> getAllDonors() {
        return new ArrayList<>(donors);
    }
}
