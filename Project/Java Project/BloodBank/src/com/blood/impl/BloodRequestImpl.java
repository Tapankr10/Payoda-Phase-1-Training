package com.blood.impl;



import com.blood.intf.BloodRequestIntf;
import com.blood.models.BloodRequest;

import java.util.ArrayList;
import java.util.List;

public class BloodRequestImpl implements BloodRequestIntf {
    private List<BloodRequest> requests = new ArrayList<>();

    @Override
    public void addRequest(BloodRequest request) {
        requests.add(request);
    }

    @Override
    public BloodRequest getRequest(String requestId) {
        return requests.stream()
                .filter(r -> r.getRequestId().equals(requestId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void updateRequest(BloodRequest request) {
        BloodRequest existingRequest = getRequest(request.getRequestId());
        if (existingRequest != null) {
            existingRequest.setBloodType(request.getBloodType());
            existingRequest.setQuantity(request.getQuantity());
            existingRequest.setRequestDate(request.getRequestDate());
        }
    }

    @Override
    public void deleteRequest(String requestId) {
        requests.removeIf(r -> r.getRequestId().equals(requestId));
    }

    @Override
    public List<BloodRequest> getAllRequests() {
        return new ArrayList<>(requests);
    }
}

