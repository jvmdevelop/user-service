package com.jvmd.userservice.payload.request;

public record UserUpdateRequest (Long id , String name, String email, String password, Double balance) {
}
