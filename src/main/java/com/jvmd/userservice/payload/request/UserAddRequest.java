package com.jvmd.userservice.payload.request;

import com.jvmd.userservice.model.Subscription;
import lombok.Data;

public record UserAddRequest(String username , String email, String password) {
}
