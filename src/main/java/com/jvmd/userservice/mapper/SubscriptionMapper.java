package com.jvmd.userservice.mapper;

import com.jvmd.userservice.model.Subscription;
import com.jvmd.userservice.payload.response.SubscriptionInfoResponse;

public class SubscriptionMapper {
    public static SubscriptionInfoResponse toResponse (Subscription subscription) {
        return SubscriptionInfoResponse.builder()
                .type(subscription.getType())
                .username(subscription.getUser().getName())
                .build();
    }
}
