package com.jvmd.userservice.payload.response;

import lombok.Builder;

import java.util.List;

@Builder
public record UserInfoResponse(String name , String email , List<SubscriptionInfoResponse> subscriptions) {
}
