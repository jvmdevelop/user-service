package com.jvmd.userservice.service;


import com.jvmd.userservice.model.ESubscritionType;
import com.jvmd.userservice.model.Subscription;
import com.jvmd.userservice.payload.request.AddSubscriptionRequest;

import java.util.List;

public interface SubscriptionService {
    Subscription addSubscription( Long id ,  AddSubscriptionRequest addSubscriptionRequest);
    List<Subscription> getAllUserSubscriptions(Long id);
    void deleteSubscription(Long id);
}
