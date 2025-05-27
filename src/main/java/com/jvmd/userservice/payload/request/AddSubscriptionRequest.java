package com.jvmd.userservice.payload.request;

import com.jvmd.userservice.model.ESubscritionType;
import com.jvmd.userservice.payload.response.SubscriptionInfoResponse;

import java.util.Date;

public record AddSubscriptionRequest(ESubscritionType subscritionType , Date date , Double amount) {
}
