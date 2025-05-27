package com.jvmd.userservice.payload.response;

import com.jvmd.userservice.model.ESubscritionType;
import lombok.Builder;

@Builder
public record SubscriptionInfoResponse(ESubscritionType type , String username) {
}
