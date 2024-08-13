package com.blood.repository;



import com.blood.models.Donation;


import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class DonationRepository {
    private static List<Donation> donations = new ArrayList<>();

    static {
        donations.add(new Donation("DN1", "O+", new Date()));
        donations.add(new Donation("DN2", "A-", new Date()));
    }

    public List<Donation> getAllDonations() {
        return new ArrayList<>(donations);
    }
}
