package com.blood.repository;

import com.blood.models.BloodRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class BloodRequestRepository {
    private static List<BloodRequest> requests = new ArrayList<>();

    
    public List<BloodRequest> getAllRequests() {
        return new ArrayList<>(requests);
    }
}
