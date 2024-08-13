package com.blood.intf;

import com.blood.models.BloodRequest;

import java.util.List;

public interface BloodRequestIntf {
    void addRequest(BloodRequest request);
    BloodRequest getRequest(String requestId);
    void updateRequest(BloodRequest request);
    void deleteRequest(String requestId);
    List<BloodRequest> getAllRequests();
}
